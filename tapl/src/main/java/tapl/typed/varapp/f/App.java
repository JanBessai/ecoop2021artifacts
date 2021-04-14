package tapl.typed.varapp.f;

public class App implements tapl.typed.varapp.App<Element, Term, Type>, Term {

	private final tapl.varapp.Term<Element, Term> left;
	private final tapl.varapp.Term<Element, Term> right;

	public App(tapl.varapp.Term<Element, Term> left, tapl.varapp.Term<Element, Term> right) {
		this.left = convert(left);
		this.right = convert(right);
	}

	@Override public tapl.varapp.Term<Element, Term> getLeft() { return left; }
	@Override public tapl.varapp.Term<Element, Term> getRight() { return right; }
}
