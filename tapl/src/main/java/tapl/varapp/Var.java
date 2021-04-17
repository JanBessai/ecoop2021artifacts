package tapl.varapp;

import java.util.function.BiFunction;

public interface Var<Elem, Tm> extends Term<Elem, Tm> {
	int getBinderIndex();
	String getName();

	default Var<Elem, Tm> replaceBinderIndex(int newIndex) { return var(newIndex, getName()); }

	default Var<Elem, Tm> replaceName(String newName) { return var(getBinderIndex(), newName); }

	@Override default String print() { return getName(); }

	@Override default boolean isVarUsed(int binderIndex) { return getBinderIndex() == binderIndex; }

	@Override default tapl.Term<Elem, Tm> nameVariable(int binderIndex, String name) {
		return (binderIndex == getBinderIndex() && !name.equals(getName()) ? replaceName(name) : this);
	}

	@Override default tapl.Term<Elem, Tm> mapVariables(int offset, BiFunction<Integer, Var<Elem, Tm>, tapl.Term<Elem, Tm>> replacementFunction) {
		return replacementFunction.apply(offset,this);
	}

	@Override default boolean isValue() { return false; }
}
