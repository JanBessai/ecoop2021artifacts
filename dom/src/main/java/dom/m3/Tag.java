package dom.m3;

/**
 * Just grab contents
 */
public interface Tag<FT> extends Exp<FT>, dom.m0.Tag<FT> {
	
	default String toText() {
		return String.format("%s\n", getContents());
	}
}
