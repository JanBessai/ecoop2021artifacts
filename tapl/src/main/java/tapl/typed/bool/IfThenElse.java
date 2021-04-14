package tapl.typed.bool;

import tapl.typed.util.TypeError;

public interface IfThenElse<Elem, Tm, Ty> extends tapl.bool.IfThenElse<Elem, Tm>, Term<Elem, Tm, Ty> {
	@Override default tapl.typed.Type<Elem, Tm, Ty> getType() {
		Term<Elem, Tm, Ty> condition = convert(getCondition());
		Type<Elem, Tm, Ty> conditionType = convert(condition.getType());
		if (!conditionType.isBool()) {
			throw new TypeError(
					String.format(
							"Got: %s Expected: %s in condition of %s",
							conditionType.print(),
							convert(bool()).print(),
							print())); 
		}
		Term<Elem, Tm, Ty> ifBranch = convert(getIfBranch());
		Term<Elem, Tm, Ty> elseBranch = convert(getElseBranch());
		Type<Elem, Tm, Ty> ifBranchType = convert(ifBranch.getType());
		Type<Elem, Tm, Ty> elseBranchType = convert(elseBranch.getType());
		if (!ifBranchType.equals(elseBranchType)) {
			throw new TypeError(
					String.format(
							"Type of if-branch %s does not match type of else branch %s in %s", 
							ifBranchType.print(),
							elseBranchType.print(),
							print()));			
		}
		return ifBranchType;
	}
}
