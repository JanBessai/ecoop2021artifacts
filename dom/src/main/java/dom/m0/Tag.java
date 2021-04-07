package dom.m0;

/**
 * Atomic TAG with no further structure. Contains a block of text.
 * Attributes can alter the way the text is rendered. 
 */
public interface Tag<FT> extends Exp<FT> {
	java.util.Hashtable<String,String> getAttributes();
	String getContents();
	String getName();
	
	default String format() {
		StringBuilder pre = new StringBuilder(String.format("<%s", getName()));
		StringBuilder post = new StringBuilder(String.format("</%s>", getName()));
		if (getAttributes().size() > 0) { pre.append(" "); }
		for (String key : getAttributes().keySet()) {
			String value = getAttributes().get(key);
			pre.append(String.format("%s=\"%s\" ", key, value));
		}
		pre.append(">");
		return pre.append(getContents()).append(post).append("\n").toString();
	}
}
