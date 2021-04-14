package tapl.typed.lambdacalculus.f;

import java.util.Optional;

public class Var implements tapl.typed.lambdacalculus.Var<Element, Term, Type>, Term {
	private final int binderIndex;
	private final String name;
	private final Optional<tapl.typed.Type<Element, Term, Type>> annotatedType;

	public Var(int binderIndex, String name, tapl.typed.Type<Element, Term, Type> annotatedType) {
		this.binderIndex = binderIndex;
		this.name = name;
		this.annotatedType = Optional.of(annotatedType);
	}

	@Override public String getName() { return name; }
	@Override public int getBinderIndex() { return binderIndex; }
	@Override public Optional<tapl.typed.Type<Element, Term, Type>> getAnnotatedType() {
		return annotatedType;
	}
	@Override public Var getSelf() { return this; }
}
