package tapl.nat.f;

public class NatTests implements tapl.nat.NatTests<Element, Term, UnaryNat> {
	@Override
	public tapl.nat.Factory<Element, Term, UnaryNat> getFactory() {
		return new Factory() {};
	}
}
