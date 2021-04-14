package tapl.arith.f;

public interface Element extends tapl.Element<Element, Term>, Factory {
    @Override default Element getSelf() { return this; }
}
