package dom.m3;

public interface Block<FT> extends Exp<FT>, dom.m0.Block<FT> {
	default String toText() {
		StringBuilder sb = new StringBuilder();
		for (dom.Exp<FT> tag : getTags()) {
			sb.append(this.convert(tag).toText());
		}
		return sb.append("\n").toString();
	}
}
