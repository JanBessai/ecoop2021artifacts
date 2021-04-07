package dom.m5;

/**
 * Reduce everything into a single tag
 */
public interface Block<FT> extends Exp<FT>, dom.m3.Block<FT> {
	default dom.Exp<FT> reduce() {
		StringBuffer sb = new StringBuffer();
		for (dom.Exp<FT> tag : getTags()) {
			sb.append(convert(tag).toText()).append("\n");
		}
		return tag("p", sb.toString(), new java.util.Hashtable<>());
	}
}
