package tapl.typed.varapp.f;

public interface Factory extends tapl.typed.varapp.Factory<Element, Term, Type> {
	@Override default Var var(int binderIndex, String name) { return var(binderIndex, name); }
	@Override default Var var(int binderIndex, String name, tapl.typed.Type<Element, Term, Type> annotatedType) {
		return var(binderIndex, name, annotatedType);
	}
	@Override default App app(tapl.Term<Element, Term> t1, tapl.Term<Element, Term> t2) {
		return app(t1, t2);
	}

	@Override default Term convert(tapl.Term<Element, Term> other) { return other.getSelfTerm(); }
	@Override default Element convert(tapl.Element<Element, Term> other) { return other.getSelf(); }
	@Override default Type convert(tapl.typed.Type<Element, Term, Type> other) { return other.getSelfType(); }
}
