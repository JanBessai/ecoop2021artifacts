package tapl.let;

import java.util.function.Function;

public interface Let<Elem, Tm> extends tapl.varapp.Term<Elem, Tm>, Factory<Elem, Tm> {
    String getName();
    tapl.Term<Elem, Tm> getValue();
    tapl.Term<Elem, Tm> getIn();

    default Let<Elem, Tm> replaceName(String by) { return let(by, getValue(), getIn()); }
    default Let<Elem, Tm> replaceValue(tapl.Term<Elem, Tm> by) { return let(getName(), by, getIn()); }
    default Let<Elem, Tm> replaceIn(tapl.Term<Elem, Tm> by) { return let(getName(), getValue(), by); }

    @Override default String print() {
        return String.format(
                "let %s = %s in %s",
                getName(),
                getValue().print(),
                convert(getIn()).nameVariable(0, getName()).print()
            );
    }

    @Override default tapl.Term<Elem, Tm> nameVariable(int binderIndex, String name) {
        return replaceValue(convert(getValue()).nameVariable(binderIndex, name))
                .replaceIn(convert(getIn()).nameVariable(binderIndex + 1, name));
    }

    @Override default tapl.Term<Elem, Tm> mapVariables(Function<tapl.varapp.Var<Elem, Tm>, tapl.Term<Elem, Tm>> replacementFunction) {
        return replaceValue(convert(getValue()).mapVariables(replacementFunction))
                .replaceIn(convert(getIn()).mapVariables(replacementFunction));
    }

    @Override default tapl.Term<Elem, Tm> eval() {
        tapl.Term<Elem, Tm> evaluatedValue = getValue().eval();
        if (evaluatedValue != getValue()) {
            return replaceIn(evaluatedValue);
        }

        if (getValue().isValue()) {
            return convert(getIn()).subst(0, getValue());
        } else {
            return this;
        }
    }

    @Override
    default boolean isVarUsed(int binderIndex) {
        return convert(getValue()).isVarUsed(binderIndex) || convert(getIn()).isVarUsed(binderIndex + 1);
    }
}
