package tapl.let.f;

import java.util.function.BiFunction;

public class LetTests implements tapl.let.LetTests<tapl.varapp.f.Element, tapl.varapp.f.Term> {
    @Override public Factory getFactory() { return new Factory() {}; }
    @Override public tapl.varapp.f.Term getValueTerm() {
        return new tapl.varapp.f.Term() {
            @Override public boolean isVarUsed(int binderIndex) { return false; }
            @Override public tapl.Term<tapl.varapp.f.Element, tapl.varapp.f.Term> nameVariable(int binderIndex, String name) { return this; }
            @Override public tapl.Term<tapl.varapp.f.Element, tapl.varapp.f.Term> mapVariables(int offset, BiFunction<Integer, tapl.varapp.Var<tapl.varapp.f.Element, tapl.varapp.f.Term>, tapl.Term<tapl.varapp.f.Element, tapl.varapp.f.Term>> replacementFunction) {
                return this;
            }
            @Override public String print() { return "dummyValue"; }
            @Override public boolean isValue() { return true; }
        };
    }
}
