package dom.m5;

/** An executable JavaScript. */
public interface Script<FT> extends Exp<FT>, dom.m3.Script<FT> {

	default dom.Exp<FT> reduce() {
		return tag("p", "script removed", new java.util.Hashtable<>());
	}
}
