package tapl.typed.let;

public interface Let<Elem, Tm, Ty> extends tapl.let.Let<Elem, Tm>, tapl.typed.varapp.Term<Elem, Tm, Ty> {
    @Override default tapl.typed.Type<Elem, Tm, Ty> getType() {
        return convert(convert(getIn()).setTypeOfVariable(0, convert(getValue()).getType())).getType();
    }

    @Override default tapl.Term<Elem, Tm> setTypeOfVariable(int binderIndex, tapl.typed.Type<Elem, Tm, Ty> type) {
        return replaceValue(convert(getValue()).setTypeOfVariable(binderIndex, type))
                .replaceIn(convert(getIn()).setTypeOfVariable(binderIndex + 1, type));
    }
}
