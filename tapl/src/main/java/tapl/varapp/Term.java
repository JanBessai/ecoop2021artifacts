package tapl.varapp;

import java.util.*;
import java.util.function.BiFunction;

public interface Term<Elem, Tm> extends tapl.Term<Elem, Tm>, Factory<Elem, Tm> {
	boolean isVarUsed(int binderIndex);
	tapl.Term<Elem, Tm> nameVariable(int binderIndex, String name);
	tapl.Term<Elem, Tm> mapVariables(int offset, BiFunction<Integer, Var<Elem, Tm>, tapl.Term<Elem, Tm>> replacementFunction);


	default tapl.Term<Elem, Tm> termShiftAbove(int shiftBy, int shiftIndexesAbove) {
		return mapVariables(shiftIndexesAbove, (offset, v) ->
				v.getBinderIndex() >= offset && shiftBy != 0 ? v.replaceBinderIndex(v.getBinderIndex() + shiftBy) : v);
	}
	default tapl.Term<Elem, Tm> termShift(int shiftBy) { return termShiftAbove(shiftBy, 0); }
	default tapl.Term<Elem, Tm> subst(int binderIndex, tapl.Term<Elem, Tm> by) {
		return mapVariables(0, (offset, v) ->
				v.getBinderIndex() == binderIndex + offset ? convert(by).termShift(binderIndex + offset) : v);
	}
	default tapl.Term<Elem, Tm> termSubstTop(tapl.Term<Elem, Tm> by) {
		Term<Elem, Tm> substituted = convert(subst(0, convert(by).termShift(1)));
		return (substituted != this ? substituted.termShift(-1) : this);
	}
	default Optional<tapl.Term<Elem, Tm>> getBodyFromAbstraction() { return Optional.empty(); }
	default tapl.Term<Elem, Tm> constantFunctionElimination() { return this; }
}
