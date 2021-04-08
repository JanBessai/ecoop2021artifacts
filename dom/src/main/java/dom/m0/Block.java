package dom.m0;

public interface Block<FT> extends dom.m0.Exp<FT> {
	
	java.util.List<dom.Exp<FT>> getTags();
	
	default String format() {
		StringBuilder sb = new StringBuilder();
		for (dom.Exp<FT> tag : getTags()) {
			sb.append(convert(tag).format());
		}
		
		return sb.append("\n").toString();
	}
	
}
