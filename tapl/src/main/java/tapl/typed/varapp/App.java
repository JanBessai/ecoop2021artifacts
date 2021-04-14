package tapl.typed.varapp;

import tapl.typed.util.TypeError;

public interface App<Elem, Tm, Ty> extends Term<Elem, Tm, Ty>, tapl.varapp.App<Elem, Tm> {
    @Override default tapl.Term<Elem, Tm> setTypeOfVariable(int binderIndex, tapl.typed.Type<Elem, Tm, Ty> type) {
        return replaceLeft(convert(getLeft()).setTypeOfVariable(binderIndex, type))
                .replaceRight(convert(getRight()).setTypeOfVariable(binderIndex, type));
    }

    @Override public default tapl.typed.Type<Elem, Tm, Ty> getType() {
        throw new TypeError(
                String.format("No typing rule for applications of %s to %s in: %s",
                        convert(getLeft()).getType().print(),
                        convert(getRight()).getType().print(),
                        print())
        );
    }
}
