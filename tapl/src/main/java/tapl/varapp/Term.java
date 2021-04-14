package tapl.varapp;

import java.util.*;
import java.util.function.Function;

public interface Term<Elem, Tm> extends tapl.Term<Elem, Tm>, Factory<Elem, Tm> {
	public boolean isVarUsed(int binderIndex);
	public tapl.Term<Elem, Tm> nameVariable(int binderIndex, String name);
	public tapl.Term<Elem, Tm> mapVariables(Function<Var<Elem, Tm>, tapl.Term<Elem, Tm>> replacementFunction);


	public default tapl.Term<Elem, Tm> termShiftAbove(int shiftBy, int shiftIndexesAbove) {
		return mapVariables(v ->
				v.getBinderIndex() >= shiftIndexesAbove ? v.replaceBinderIndex(v.getBinderIndex() +  shiftBy) : v);
	}
	public default tapl.Term<Elem, Tm> termShift(int shiftBy) { return termShiftAbove(shiftBy, 0); }
	public default tapl.Term<Elem, Tm> subst(int binderIndex, tapl.Term<Elem, Tm> by) {
		Term<Elem, Tm> shifted = convert(convert(by).termShift(binderIndex));
		return mapVariables(v -> v.getBinderIndex() == binderIndex ? shifted : v);
	}
	public default tapl.Term<Elem, Tm> termSubstTop(tapl.Term<Elem, Tm> by) {
		return convert(subst(0, convert(by).termShift(1))).termShift(-1);
	}
	public default Optional<tapl.Term<Elem, Tm>> getBodyFromAbstraction() { return Optional.empty(); }
	public default tapl.Term<Elem, Tm> constantFunctionElimination() { return this; }
}
