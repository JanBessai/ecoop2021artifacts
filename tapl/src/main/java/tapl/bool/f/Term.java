package tapl.bool.f;

public interface Term extends Element, tapl.bool.Term<Element, Term> {
	@Override default Term getSelfTerm() { return this;	}
}
