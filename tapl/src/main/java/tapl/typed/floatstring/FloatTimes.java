package tapl.typed.floatstring;

import tapl.typed.util.TypeError;

public interface FloatTimes<Elem, Tm, Ty> extends tapl.floatstring.FloatTimes<Elem, Tm>, Term<Elem, Tm, Ty> {
	@Override default tapl.typed.Type<Elem, Tm, Ty> getType() {
		Term<Elem, Tm, Ty> left = convert(getLeft());
		Type<Elem, Tm, Ty> leftType = convert(left.getType());
		if (!leftType.isFloat()) {
			throw new TypeError(
						String.format("Expecting %s got %s in left hand side of %s",
								floatTy().print(),
								leftType.print(),
								print()));
		}
		
		Term<Elem, Tm, Ty> right = convert(getRight());
		Type<Elem, Tm, Ty> rightType = convert(right.getType());
		if (!rightType.isFloat()) {
			throw new TypeError(
						String.format("Expecting %s got %s in right hand side of %s",
								floatTy().print(),
								rightType.print(),
								print()));
		}
		return rightType;
	}
}
