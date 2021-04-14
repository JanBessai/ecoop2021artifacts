package tapl.lambdacalculus.f;

public interface Factory extends tapl.lambdacalculus.Factory<Element, Term> {
	@Override default Var var(int binderIndex, String name) { return var(binderIndex, name); }
	@Override default App app(tapl.Term<Element, Term> t1, tapl.Term<Element, Term> t2) {
		return app(t1, t2);
	}
	@Override default Lambda lambda(String name, tapl.Term<Element, Term> body) {
		return lambda(name, body);
	}

	@Override default Term convert(tapl.Term<Element, Term> other) { return other.getSelfTerm(); }
	@Override default Element convert(tapl.Element<Element, Term> other) { return other.getSelf(); }
}
