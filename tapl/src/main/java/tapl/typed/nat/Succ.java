package tapl.typed.nat;

import tapl.typed.util.TypeError;

public interface Succ<Elem, Tm, UNat, Ty> extends tapl.nat.Succ<Elem, Tm, UNat>, UnaryNat<Elem, Tm, UNat, Ty> {
	@Override default tapl.typed.Type<Elem, Tm, Ty> getType() {
		Type<Elem, Tm, UNat, Ty> ofType = convert(convert(getOf()).getType());
		if (!ofType.isNat() ) {
			throw new TypeError(
					String.format(
							"Type of %s is %s expected %s in %s",
							getOf().print(),
							ofType.print(),
							nat().print(),
							print()));	
		}
		return ofType;		
	}
}
