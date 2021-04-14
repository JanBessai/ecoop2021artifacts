package tapl.typed.bool.f;

public interface Term extends Element, tapl.typed.bool.Term<Element, Term, Type> {
	@Override default Term getSelfTerm() { return this;	}
}
