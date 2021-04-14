package tapl.varapp;

import java.util.function.Function;

public interface App<Elem, Tm> extends Term<Elem, Tm> {
    public tapl.Term<Elem, Tm> getLeft();
    public tapl.Term<Elem, Tm> getRight();

    public default App<Elem, Tm> replaceLeft(tapl.Term<Elem, Tm> by) { return app(by, getRight()); }
    public default App<Elem, Tm> replaceRight(tapl.Term<Elem, Tm> by) { return app(getLeft(), by); }

    @Override public default String print() { return String.format("%s %s", getLeft().print(), getRight().print()); }

    @Override public default boolean isVarUsed(int binderIndex) {
        return convert(getLeft()).isVarUsed(binderIndex) || convert(getRight()).isVarUsed(binderIndex);
    }
    @Override public default tapl.Term<Elem, Tm> nameVariable(int binderIndex, String name) {
        return replaceLeft(convert(getLeft()).nameVariable(binderIndex, name))
                .replaceRight(convert(getRight()).nameVariable(binderIndex, name));
    }
    @Override public default tapl.Term<Elem, Tm> mapVariables(Function<Var<Elem, Tm>, tapl.Term<Elem, Tm>> replacementFunction) {
        return replaceLeft(convert(getLeft()).mapVariables(replacementFunction))
                .replaceRight(convert(getRight()).mapVariables(replacementFunction));
    }
    @Override public default tapl.Term<Elem, Tm> eval() {
        tapl.Term<Elem, Tm> left = getLeft();
        tapl.Term<Elem, Tm> leftStep = left.eval();
        if (leftStep != left) {
            return replaceLeft(leftStep);
        }
        tapl.Term<Elem, Tm> right = getRight();
        tapl.Term<Elem, Tm> rightStep = right.eval();
        if (rightStep != right) {
            return replaceRight(rightStep);
        }
        return this;
    }
    @Override public default tapl.Term<Elem, Tm> constantFunctionElimination() {
        Term<Elem, Tm> elimLeft = convert(convert(getLeft()).constantFunctionElimination());
        return elimLeft.getBodyFromAbstraction()
                .map(this::convert)
                .filter(b -> !b.isVarUsed(0))
                .map(b -> b.termShift(-1))
                .orElseGet(() -> app(elimLeft, convert(getRight()).constantFunctionElimination()));
    }

    @Override public default boolean isValue() { return false; }
}
