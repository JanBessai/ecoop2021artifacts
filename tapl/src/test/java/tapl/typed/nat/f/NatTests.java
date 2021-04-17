package tapl.typed.nat.f;

public class NatTests implements tapl.typed.nat.NatTests<Element, Term, UnaryNat, Type> {
    @Override public Factory getFactory() { return new Factory() {}; }
    @Override public Term getNonNatTerm() {
        return new Term() {
            @Override public tapl.typed.Type<Element, Term, Type> getType() {
                return new Type() {
                    @Override public boolean equals(tapl.typed.Type<Element, Term, Type> other) {
                        return other.getClass().equals(this.getClass());
                    }

                    @Override public String print() {
                        return "Not a Nat";
                    }
                };
            }

            @Override public String print() {
                return "NonNatDummy";
            }
        };
    }
}
