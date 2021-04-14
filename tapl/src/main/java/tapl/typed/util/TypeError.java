package tapl.typed.util;

public class TypeError extends RuntimeException {
	private static final long serialVersionUID = 1L;
	public TypeError(String description) { super(description); }
}
