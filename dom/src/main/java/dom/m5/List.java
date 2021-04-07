package dom.m5;

/** An executable JavaScript. */
public interface List<FT> extends Exp<FT>, dom.m4.List<FT> {

	default dom.Exp<FT> reduce() {
		return tag("p", "script removed", new java.util.Hashtable<>());
	}
}
