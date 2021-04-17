package tapl.lambdacalculus;

import java.util.Optional;
import java.util.function.BiFunction;

public interface Lambda<Elem, Tm> extends Term<Elem, Tm> {
    String getName();
    tapl.Term<Elem, Tm> getBody();

    default Lambda<Elem, Tm> replaceName(String by) { return lambda(by, getBody()); }
    default Lambda<Elem, Tm> replaceBody(tapl.Term<Elem, Tm> by) { return lambda(getName(), by); }

    @Override default String print() {
        return String.format(
                "(\\ %s . %s)",
                getName(),
                convert(getBody()).nameVariable(0, getName()).print()
            );
    }
    @Override default tapl.Term<Elem, Tm> nameVariable(int binderIndex, String name) {
        tapl.Term<Elem, Tm> newBody = convert(getBody()).nameVariable(binderIndex + 1, name);
        return (getBody() != newBody ? replaceBody(newBody) : this);
    }
    @Override default tapl.Term<Elem, Tm> mapVariables(int offset, BiFunction<Integer, tapl.varapp.Var<Elem, Tm>, tapl.Term<Elem, Tm>> replacementFunction) {
        tapl.Term<Elem, Tm> newBody = convert(getBody()).mapVariables(offset, (_offset, v) -> replacementFunction.apply(_offset + 1, v));
        return (getBody() != newBody ? replaceBody(newBody) : this);
    }
    @Override default Optional<Lambda<Elem, Tm>> matchAbstraction() { return Optional.of(this); }
    @Override default Optional<tapl.Term<Elem, Tm>> getBodyFromAbstraction() { return Optional.of(getBody()); }
    @Override default boolean isVarUsed(int binderIndex) { return convert(getBody()).isVarUsed(binderIndex + 1); }
}
