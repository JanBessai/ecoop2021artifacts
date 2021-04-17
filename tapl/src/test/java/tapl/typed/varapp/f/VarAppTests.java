package tapl.typed.varapp.f;

public class VarAppTests implements tapl.typed.varapp.VarAppTests<Element, Term, Type> {
    @Override public Factory getFactory() { return new Factory() {}; }
    @Override public Type getType() {
        return new Type() {
            @Override public boolean equals(tapl.typed.Type<Element, Term, Type> other) {  return other.getClass().equals(this.getClass()); }
            @Override public String print() { return "Dummy Type"; }
        };
    }
}
