package tapl.typed.lambdacalculus;

import tapl.typed.util.TypeError;

import java.util.Optional;

public interface App<Elem, Tm, Ty> extends tapl.typed.varapp.App<Elem, Tm, Ty>, Term<Elem, Tm, Ty> {
    @Override default tapl.typed.Type<Elem, Tm, Ty> getType() {
        tapl.typed.Type<Elem, Tm, Ty> leftType = convert(getRight()).getType();
        tapl.typed.Type<Elem, Tm, Ty> rightType = convert(getRight()).getType();

        Optional<Arrow<Elem, Tm, Ty>> arrowOpt = convert(leftType).matchArrow();
        if (arrowOpt.isEmpty()) {
            throw new TypeError(
                    String.format("Expecting type of function to be an arrow, got %s in: %s",
                            leftType.print(),
                            print())
            );
        }
        Arrow<Elem, Tm, Ty> arrow = arrowOpt.get();
        if (!arrow.getSource().equals(rightType)) {
            throw new TypeError(
                    String.format("Expecting type of argument to be %s, got %s in: %s",
                            arrow.getSource().print(),
                            rightType.print(),
                            print())
            );
        }
        return arrow.getTarget();
    }
}
