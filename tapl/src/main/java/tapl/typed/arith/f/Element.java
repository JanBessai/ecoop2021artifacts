package tapl.typed.arith.f;

public interface Element extends Factory, tapl.Element<Element, Term> {
	@Override default Element getSelf() { return this; }
}
