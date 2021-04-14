package tapl.varapp;

import java.util.function.Function;

public interface Var<Elem, Tm> extends Term<Elem, Tm> {
	public int getBinderIndex();
	public String getName();

	public default Var<Elem, Tm> replaceBinderIndex(int newIndex) { return var(newIndex, getName()); }

	public default Var<Elem, Tm> replaceName(String newName) { return var(getBinderIndex(), newName); }

	@Override public default String print() { return getName(); }

	@Override public default boolean isVarUsed(int binderIndex) { return getBinderIndex() == binderIndex; }

	@Override public default tapl.Term<Elem, Tm> nameVariable(int binderIndex, String name) {
		if (binderIndex == getBinderIndex()) {
			return replaceName(name);
		} else {
			return this;
		}
	}

	@Override public default tapl.Term<Elem, Tm> mapVariables(Function<Var<Elem, Tm>, tapl.Term<Elem, Tm>> replacementFunction) {
		return replacementFunction.apply(this);
	}
}
