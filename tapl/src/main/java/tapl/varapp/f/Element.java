package tapl.varapp.f;

public interface Element extends tapl.Element<Element, Term>, Factory {
	@Override default Element getSelf() { return this; }
}
