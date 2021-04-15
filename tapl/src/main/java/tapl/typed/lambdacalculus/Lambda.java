package tapl.typed.lambdacalculus;

import tapl.typed.Type;
import tapl.typed.util.TypeError;

import java.util.Optional;

public interface Lambda<Elem, Tm, Ty> extends tapl.lambdacalculus.Lambda<Elem, Tm>, Term<Elem, Tm, Ty>, Factory<Elem, Tm, Ty> {
    Optional<tapl.typed.Type<Elem, Tm, Ty>> getBoundType();

    @Override default tapl.lambdacalculus.Lambda<Elem, Tm> replaceName(String by) {
        tapl.lambdacalculus.Lambda<Elem, Tm> replaced = tapl.lambdacalculus.Lambda.super.replaceName(by);
        return getBoundType().<tapl.lambdacalculus.Lambda<Elem, Tm>>map(ty -> lambda(by, ty, getBody()))
                .orElse(replaced);
    }
    default tapl.typed.lambdacalculus.Lambda<Elem, Tm, Ty> replaceBoundType(tapl.typed.Type<Elem, Tm, Ty> by) { return lambda(getName(), by, getBody()); }
    @Override default tapl.lambdacalculus.Lambda<Elem, Tm> replaceBody(tapl.Term<Elem, Tm> by) {
        tapl.lambdacalculus.Lambda<Elem, Tm> replaced = tapl.lambdacalculus.Lambda.super.replaceBody(by);
        return getBoundType().<tapl.lambdacalculus.Lambda<Elem, Tm>>map(ty -> lambda(getName(), ty, by))
                .orElse(replaced);
    }

    @Override default String print() {
        return String.format(
                "\\ %s : %s . %s",
                getName(),
                getBoundType().map(ty -> ty.print()).orElse("unknown"),
                convert(getBody()).nameVariable(0, getName()).print()
            );
    }

    @Override default Type<Elem, Tm, Ty> getType() {
        Optional<tapl.typed.Type<Elem, Tm, Ty>> sourceOpt = getBoundType();
        if (sourceOpt.isEmpty()) {
            throw new TypeError("source annotation required");
        }
        tapl.typed.Type<Elem, Tm, Ty> source = sourceOpt.get();
        return arrow(source, convert(convert(getBody()).setTypeOfVariable(0, source)).getType());
    }

    @Override
    default tapl.Term<Elem, Tm> setTypeOfVariable(int binderIndex, Type<Elem, Tm, Ty> type) {
        return replaceBody(convert(getBody()).setTypeOfVariable(binderIndex + 1, type));
    }
}
