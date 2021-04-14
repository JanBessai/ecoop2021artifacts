package tapl.varapp.f;

public interface Factory extends tapl.varapp.Factory<Element, Term> {
	@Override default Var var(int binderIndex, String name) { return new Var(binderIndex, name); }
	@Override default App app(tapl.Term<Element, Term> t1, tapl.Term<Element, Term> t2) {
		return new App(t1, t2);
	}

	@Override default Term convert(tapl.Term<Element, Term> other) { return other.getSelfTerm(); }
	@Override default Element convert(tapl.Element<Element, Term> other) { return other.getSelf(); }
}
