package tapl.lambdacalculus.f;

public class Var implements tapl.lambdacalculus.Var<Element, Term>, Term {
	private final int binderIndex;
	private final String name;
	
	public Var(int binderIndex, String name) {
		this.binderIndex = binderIndex;
		this.name = name;
	}

	@Override public int getBinderIndex() { return binderIndex; }
	@Override public String getName() { return name; }
}
