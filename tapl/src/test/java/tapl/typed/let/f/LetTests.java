package tapl.typed.let.f;

import java.util.function.BiFunction;

public class LetTests implements tapl.typed.let.LetTests<tapl.typed.varapp.f.Element, tapl.typed.varapp.f.Term, tapl.typed.varapp.f.Type> {
    @Override public Factory getFactory() { return new Factory () {}; }
    @Override public tapl.typed.varapp.f.Term getValueTerm() {
        return new tapl.typed.varapp.f.Term() {
            @Override public boolean isVarUsed(int binderIndex) { return false; }
            @Override public tapl.Term<tapl.typed.varapp.f.Element, tapl.typed.varapp.f.Term> nameVariable(int binderIndex, String name) { return this; }
            @Override public tapl.Term<tapl.typed.varapp.f.Element, tapl.typed.varapp.f.Term>
                mapVariables(int offset, BiFunction<Integer, tapl.varapp.Var<tapl.typed.varapp.f.Element, tapl.typed.varapp.f.Term>,
                                                    tapl.Term<tapl.typed.varapp.f.Element, tapl.typed.varapp.f.Term>> replacementFunction) {
                return this;
            }
            @Override public String print() { return "dummyValue"; }
            @Override public boolean isValue() { return true; }
            @Override public tapl.Term<tapl.typed.varapp.f.Element, tapl.typed.varapp.f.Term>
                setTypeOfVariable(int binderIndex, tapl.typed.Type<tapl.typed.varapp.f.Element, tapl.typed.varapp.f.Term, tapl.typed.varapp.f.Type> ty) {
                return this;
            }
            @Override public tapl.typed.Type<tapl.typed.varapp.f.Element, tapl.typed.varapp.f.Term, tapl.typed.varapp.f.Type> getType() {
                return LetTests.this.getType();
            }
        };
    }
    @Override public tapl.typed.varapp.f.Type getType() {
        return new tapl.typed.varapp.f.Type() {
            @Override public boolean equals(tapl.typed.Type<tapl.typed.varapp.f.Element, tapl.typed.varapp.f.Term, tapl.typed.varapp.f.Type> other) {
                return other.getClass().equals(this.getClass());
            }
            @Override public String print() {
                return "Dummy Type";
            }
        };
    }
}
