package tapl.floatstring;

public interface Factory<Elem, Tm> extends tapl.Factory<Elem, Tm> {
	ConstString<Elem, Tm> constString(String text);
	ConstFloat<Elem, Tm> constFloat(float x);
	FloatTimes<Elem, Tm> floatTimes(tapl.Term<Elem, Tm> left, tapl.Term<Elem, Tm> right);
	
	@Override Term<Elem, Tm> convert(tapl.Term<Elem, Tm> other);
}
