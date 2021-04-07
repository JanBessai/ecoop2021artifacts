package dom.m5;

/**
 * List matches to <ol><li>Tag1<li></li>Tag2</li></ol>
 */
public interface Table<FT> extends dom.m5.Exp<FT> {
	java.util.List<dom.Exp<FT>> getHeader();
	java.util.List<java.util.List<dom.Exp<FT>>> getRows();
	java.util.Hashtable<String,String> getAttributes();

	default String format() {
		StringBuilder sb = new StringBuilder("<table");
		if (getAttributes().size() > 0) { sb.append(" "); }
		for (String key : getAttributes().keySet()) {
			String value = getAttributes().get(key);
			sb.append(String.format("%s=\"%s\" ", key, value));
		}
		sb.append(">");
		sb.append("<tr>");
		for (dom.Exp<FT> header : getHeader()) {
			sb.append(convert(header).format());
		}
		sb.append("</tr>\n");
		for (java.util.List<dom.Exp<FT>> row : getRows()) {
			sb.append("<tr>");
			for (dom.Exp<FT> item : row) {
				sb.append(convert(item).format());
			}
			sb.append("</tr>\n");
		}
		sb.append("</table>\n");

		return sb.toString();
	}

	default String toText() {
		StringBuilder sb = new StringBuilder();
		for (dom.Exp<FT> header : getHeader()) {
			sb.append("|").append(convert(header).toText().toUpperCase()).append("\t");
		}
		sb.append("\n");
		for (java.util.List<dom.Exp<FT>> row : getRows()) {
			sb.append("|");
			for (dom.Exp<FT> item : row) {
				sb.append(String.format("%s\t", convert(item).toText()));
			}
			sb.append("\n");
		}
		sb.append("\n");

		return sb.toString();
	}

	default dom.Exp<FT> reduce() {
		return tag("p", convert(this).toText(), new java.util.Hashtable<>());
	}
}
