package tapl.typed.varapp.f;

import java.util.Optional;

public class Var implements tapl.typed.varapp.Var<Element, Term, Type>, Term {
	private final int binderIndex;
	private final String name;
	private final tapl.typed.Type<Element, Term, Type> annotatedType;

	public Var(int binderIndex, String name) { this(binderIndex, name, null); }
	public Var(int binderIndex, String name, tapl.typed.Type<Element, Term, Type> annotatedType) {
		this.binderIndex = binderIndex;
		this.name = name;
		this.annotatedType = annotatedType;
	}

	@Override public String getName() { return name; }
	@Override public int getBinderIndex() { return binderIndex; }
	@Override public Optional<tapl.typed.Type<Element, Term, Type>> getAnnotatedType() { return Optional.ofNullable(annotatedType);	}
}
