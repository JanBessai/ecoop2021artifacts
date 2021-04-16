package tapl.varapp;

import java.util.function.Function;

public interface App<Elem, Tm> extends Term<Elem, Tm> {
    tapl.Term<Elem, Tm> getLeft();
    tapl.Term<Elem, Tm> getRight();

    default App<Elem, Tm> replaceLeft(tapl.Term<Elem, Tm> by) { return app(by, getRight()); }
    default App<Elem, Tm> replaceRight(tapl.Term<Elem, Tm> by) { return app(getLeft(), by); }

    @Override default String print() { return String.format("(%s %s)", getLeft().print(), getRight().print()); }

    @Override default boolean isVarUsed(int binderIndex) {
        return convert(getLeft()).isVarUsed(binderIndex) || convert(getRight()).isVarUsed(binderIndex);
    }
    @Override default tapl.Term<Elem, Tm> nameVariable(int binderIndex, String name) {
        tapl.Term<Elem, Tm> newLeft = convert(getLeft()).nameVariable(binderIndex, name);
        tapl.Term<Elem, Tm> newRight = convert(getRight()).nameVariable(binderIndex, name);
        App<Elem, Tm> result = (newLeft != getLeft() ? replaceLeft(newLeft) : this);
        result = (newRight != getRight() ? result.replaceRight(newRight) : result);
        return result;
    }
    @Override default tapl.Term<Elem, Tm> mapVariables(Function<Var<Elem, Tm>, tapl.Term<Elem, Tm>> replacementFunction) {
        tapl.Term<Elem, Tm> newLeft = convert(getLeft()).mapVariables(replacementFunction);
        tapl.Term<Elem, Tm> newRight = convert(getRight()).mapVariables(replacementFunction);
        App<Elem, Tm> result = (newLeft != getLeft() ? replaceLeft(newLeft) : this);
        result = (newRight != getRight() ? result.replaceRight(newRight) : result);
        return result;
    }
    @Override default tapl.Term<Elem, Tm> eval() {
        tapl.Term<Elem, Tm> left = getLeft();
        tapl.Term<Elem, Tm> leftStep = left.eval();
        if (leftStep != left) { return replaceLeft(leftStep); }
        tapl.Term<Elem, Tm> right = getRight();
        tapl.Term<Elem, Tm> rightStep = right.eval();
        if (rightStep != right) { return replaceRight(rightStep); }
        return this;
    }
    @Override default tapl.Term<Elem, Tm> constantFunctionElimination() {
        Term<Elem, Tm> elimLeft = convert(convert(getLeft()).constantFunctionElimination());
        return elimLeft.getBodyFromAbstraction()
                .map(this::convert)
                .filter(b -> !b.isVarUsed(0))
                .map(b -> b.termShift(-1))
                .orElseGet(() -> {
                    Term<Elem, Tm> elimRight = convert(convert(getRight()).constantFunctionElimination());
                    if (elimLeft != getLeft() || elimRight != getRight()) {
                        return app(elimLeft, elimRight);
                    } else {
                        return this;
                    }
                });
    }

    @Override default boolean isValue() { return false; }
}
