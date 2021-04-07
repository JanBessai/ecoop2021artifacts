package dom.m4;

/**
 * List matches to <ol><li>Tag1<li></li>Tag2</li></ol>
 */
public interface List<FT> extends dom.m3.Exp<FT> {
	java.util.List<dom.Exp<FT>> getItems();

	default String format() {
		StringBuilder sb = new StringBuilder("<ol>\n");
		for (dom.Exp<FT> item : getItems()) {
			sb.append(String.format("<li>%s</li>\n", convert(item).format()));
		}
		sb.append("</ol>/n");

		return sb.toString();
	}

	default String toText() {
		int idx = 1;
		StringBuilder sb = new StringBuilder();
		for (dom.Exp<FT> item : getItems()) {
			sb.append(String.format("%d. %s\n", idx++, convert(item).toText()));
		}

		return sb.toString();
	}
}
