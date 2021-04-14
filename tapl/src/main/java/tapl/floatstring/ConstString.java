package tapl.floatstring;

public interface ConstString<Elem, Tm> extends Term<Elem, Tm> {
	String getText();
	
	@Override default String print() { return String.format("\"%s\"", getText()); }
}
