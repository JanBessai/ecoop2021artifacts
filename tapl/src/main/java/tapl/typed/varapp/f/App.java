package tapl.typed.varapp.f;

public class App implements tapl.typed.varapp.App<Element, Term, Type>, Term {

	private final tapl.Term<Element, Term> left;
	private final tapl.Term<Element, Term> right;

	public App(tapl.Term<Element, Term> left, tapl.Term<Element, Term> right) {
		this.left = left;
		this.right = right;
	}

	@Override public tapl.Term<Element, Term> getLeft() { return left; }
	@Override public tapl.Term<Element, Term> getRight() { return right; }
}
