package tapl.varapp;

public interface Factory<Elem, Tm> extends tapl.Factory<Elem, Tm> {
	public Var<Elem, Tm> var(int binderIndex, String name);
	public App<Elem, Tm> app(tapl.Term<Elem, Tm> t1, tapl.Term<Elem, Tm> t2);

	@Override public Term<Elem, Tm> convert(tapl.Term<Elem, Tm> other);
}
