package tapl.typed.varapp;

import tapl.typed.util.TypeError;

import java.util.Optional;

public interface Var<Elem, Tm, Ty> extends tapl.varapp.Var<Elem, Tm>, Term<Elem, Tm, Ty> {
    Optional<tapl.typed.Type<Elem, Tm, Ty>> getAnnotatedType();

    default tapl.varapp.Var<Elem, Tm> replaceType(tapl.typed.Type<Elem, Tm, Ty> by) { return var(getBinderIndex(), getName(), by); }
    default tapl.varapp.Var<Elem, Tm> clearType() { return var(getBinderIndex(), getName()); }
    @Override default tapl.varapp.Var<Elem, Tm> replaceBinderIndex(int newIndex) {
        tapl.varapp.Var<Elem, Tm> replaced = tapl.varapp.Var.super.replaceBinderIndex(newIndex);
        return getAnnotatedType()
                .<tapl.varapp.Var<Elem, Tm>>map(ty -> var(replaced.getBinderIndex(), replaced.getName(), ty))
                .orElse(replaced);
    }
    @Override default tapl.varapp.Var<Elem, Tm> replaceName(String newName) {
        tapl.varapp.Var<Elem, Tm> replaced = tapl.varapp.Var.super.replaceName(newName);
        return getAnnotatedType()
                .<tapl.varapp.Var<Elem, Tm>>map(ty -> var(replaced.getBinderIndex(), replaced.getName(), ty))
                .orElse(replaced);
    }

    @Override default tapl.Term<Elem, Tm> setTypeOfVariable(int binderIndex, tapl.typed.Type<Elem, Tm, Ty> type) {
        return (binderIndex == getBinderIndex() ? replaceType(type) : this);
    }
    @Override default tapl.typed.Type<Elem, Tm, Ty> getType() {
        return getAnnotatedType()
                .orElseGet(() -> { throw new TypeError(String.format("Cannot infer type for variable %s", print())); });
    }
}
