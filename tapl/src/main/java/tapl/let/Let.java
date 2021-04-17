package tapl.let;

import java.util.function.BiFunction;

public interface Let<Elem, Tm> extends tapl.varapp.Term<Elem, Tm>, Factory<Elem, Tm> {
    String getName();
    tapl.Term<Elem, Tm> getValue();
    tapl.Term<Elem, Tm> getIn();

    default Let<Elem, Tm> replaceName(String by) { return let(by, getValue(), getIn()); }
    default Let<Elem, Tm> replaceValue(tapl.Term<Elem, Tm> by) { return let(getName(), by, getIn()); }
    default Let<Elem, Tm> replaceIn(tapl.Term<Elem, Tm> by) { return let(getName(), getValue(), by); }

    @Override default String print() {
        return String.format(
                "(let %s = %s in %s)",
                getName(),
                getValue().print(),
                convert(getIn()).nameVariable(0, getName()).print()
            );
    }

    @Override default tapl.Term<Elem, Tm> nameVariable(int binderIndex, String name) {
        tapl.Term<Elem, Tm> newValue = convert(getValue()).nameVariable(binderIndex, name);
        tapl.Term<Elem, Tm> newIn = convert(getIn()).nameVariable(binderIndex + 1, name);
        Let<Elem, Tm> result = (getValue() != newValue ? replaceValue(newValue) : this);
        result = (getIn() != newIn ? result.replaceIn(newIn) : result);
        return result;
    }

    @Override default tapl.Term<Elem, Tm> mapVariables(int offset, BiFunction<Integer, tapl.varapp.Var<Elem, Tm>, tapl.Term<Elem, Tm>> replacementFunction) {
        tapl.Term<Elem, Tm> newValue = convert(getValue()).mapVariables(offset, replacementFunction);
        tapl.Term<Elem, Tm> newIn = convert(getIn()).mapVariables(offset, (_offset, v) -> replacementFunction.apply(_offset + 1, v));
        Let<Elem, Tm> result = (getValue() != newValue ? replaceValue(newValue) : this);
        result = (getIn() != newIn ? result.replaceIn(newIn) : result);
        return result;
    }

    @Override default tapl.Term<Elem, Tm> eval() {
        tapl.Term<Elem, Tm> evaluatedValue = getValue().eval();
        if (evaluatedValue != getValue()) { return replaceValue(evaluatedValue); }
        return (getValue().isValue() ? convert(getIn()).subst(0, getValue()) : this);
    }

    @Override
    default boolean isVarUsed(int binderIndex) {
        return convert(getValue()).isVarUsed(binderIndex) || convert(getIn()).isVarUsed(binderIndex + 1);
    }

    @Override default boolean isValue() { return false; }
}
