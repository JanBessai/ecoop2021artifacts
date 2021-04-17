package tapl.typed.lambdacalculus.f;

public interface Factory extends tapl.typed.lambdacalculus.Factory<Element, Term, Type> {
	@Override default Var var(int binderIndex, String name) { return new Var(binderIndex, name); }
	@Override default Var var(int binderIndex, String name, tapl.typed.Type<Element, Term, Type> annotatedType) {
		return new Var(binderIndex, name, annotatedType);
	}
	@Override default App app(tapl.Term<Element, Term> t1, tapl.Term<Element, Term> t2) {
		return new App(t1, t2);
	}
	@Override default Lambda lambda(String name, tapl.Term<Element, Term> body) {
		return new Lambda(name, body);
	}
	@Override default Lambda lambda(String name, tapl.typed.Type<Element, Term, Type> type, tapl.Term<Element, Term> body) {
		return new Lambda(name, type, body);
	}
	@Override default Arrow arrow(tapl.typed.Type<Element, Term, Type> source, tapl.typed.Type<Element, Term, Type> target) {
		return new Arrow(source, target);
	}

	@Override default Term convert(tapl.Term<Element, Term> other) { return other.getSelfTerm(); }
	@Override default Element convert(tapl.Element<Element, Term> other) { return other.getSelf(); }
	@Override default Type convert(tapl.typed.Type<Element, Term, Type> other) { return other.getSelfType(); }
}
