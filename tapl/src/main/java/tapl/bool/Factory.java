package tapl.bool;

public interface Factory<Elem, Tm> extends tapl.Factory<Elem, Tm> {
	ConstTrue<Elem, Tm> constTrue();
	ConstFalse<Elem, Tm> constFalse();
	IfThenElse<Elem, Tm> ifThenElse(tapl.Term<Elem, Tm> cond, tapl.Term<Elem, Tm> ifBranch, tapl.Term<Elem, Tm> elseBranch);

	@Override Term<Elem, Tm> convert(tapl.Term<Elem, Tm> other);
}
