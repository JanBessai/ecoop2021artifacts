package tapl.bool.f;

public interface Element extends Factory, tapl.Element<Element, Term> {
	@Override default Element getSelf() { return this; }
}
