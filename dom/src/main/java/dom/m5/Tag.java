package dom.m5;

/**
 * Strip away all formatting for a tag, and just pass through
 */
public interface Tag<FT> extends Exp<FT>, dom.m3.Tag<FT> {
	
	default dom.Exp<FT> reduce() {
		return tag(getName(), getContents());
	}
}
