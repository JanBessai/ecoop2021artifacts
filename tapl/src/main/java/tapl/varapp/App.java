package tapl.varapp;

import java.util.function.Function;

public interface App<Elem, Tm> extends Term<Elem, Tm> {
    tapl.Term<Elem, Tm> getLeft();
    tapl.Term<Elem, Tm> getRight();

    default App<Elem, Tm> replaceLeft(tapl.Term<Elem, Tm> by) { return app(by, getRight()); }
    default App<Elem, Tm> replaceRight(tapl.Term<Elem, Tm> by) { return app(getLeft(), by); }

    @Override default String print() { return String.format("%s %s", getLeft().print(), getRight().print()); }

    @Override default boolean isVarUsed(int binderIndex) {
        return convert(getLeft()).isVarUsed(binderIndex) || convert(getRight()).isVarUsed(binderIndex);
    }
    @Override default tapl.Term<Elem, Tm> nameVariable(int binderIndex, String name) {
        return replaceLeft(convert(getLeft()).nameVariable(binderIndex, name))
                .replaceRight(convert(getRight()).nameVariable(binderIndex, name));
    }
    @Override default tapl.Term<Elem, Tm> mapVariables(Function<Var<Elem, Tm>, tapl.Term<Elem, Tm>> replacementFunction) {
        return replaceLeft(convert(getLeft()).mapVariables(replacementFunction))
                .replaceRight(convert(getRight()).mapVariables(replacementFunction));
    }
    @Override default tapl.Term<Elem, Tm> eval() {
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
    @Override default tapl.Term<Elem, Tm> constantFunctionElimination() {
        Term<Elem, Tm> elimLeft = convert(convert(getLeft()).constantFunctionElimination());
        return elimLeft.getBodyFromAbstraction()
                .map(this::convert)
                .filter(b -> !b.isVarUsed(0))
                .map(b -> b.termShift(-1))
                .orElseGet(() -> app(elimLeft, convert(getRight()).constantFunctionElimination()));
    }

    @Override default boolean isValue() { return false; }
}
