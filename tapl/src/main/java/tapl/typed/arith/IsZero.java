package tapl.typed.arith;

import tapl.typed.util.TypeError;

public interface IsZero<Elem, Tm, UNat, Ty> extends tapl.arith.IsZero<Elem, Tm, UNat>, Term<Elem, Tm, UNat, Ty> {
    @Override default tapl.typed.Type<Elem, Tm, Ty> getType() {
        Type<Elem, Tm, UNat, Ty> toTestType = convert(convert(getToTest()).getType());
        if (toTestType.isNat()) {
            return bool();
        } else {
            throw new TypeError(
                    String.format("Got %s expected %s in argument of %s",
                            toTestType.print(),
                            nat().print(),
                            print())
            );
        }
    }
}
