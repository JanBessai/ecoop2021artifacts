package dom.m3;

/** An executable JavaScript. */
public interface Script<FT> extends Exp<FT>, dom.m1.Script<FT> {
	
	default String toText() {
		return "";
	}
}
