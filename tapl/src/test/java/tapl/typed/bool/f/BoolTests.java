package tapl.typed.bool.f;

public class BoolTests implements tapl.typed.bool.BoolTests<Element, Term, Type> {
    @Override public Factory getFactory() { return new Factory() {}; }
    @Override public Term getNonBoolTerm() {
        return new Term() {
            @Override public tapl.typed.Type<Element, Term, Type> getType() {
                return new Type() {
                    @Override public boolean equals(tapl.typed.Type<Element, Term, Type> other) {
                        return other.getClass().equals(this.getClass());
                    }

                    @Override public String print() {
                        return "Not a Bool";
                    }
                };
            }

            @Override public String print() {
                return "NonBooleanDummy";
            }
        };
    }
}
