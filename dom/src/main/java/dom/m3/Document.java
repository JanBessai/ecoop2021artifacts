package dom.m3;

public interface Document<FT> extends Exp<FT>, dom.m0.Document<FT> {
	default String toText() {
		return String.format("%s\n", convert(getBody()).toText());
	}
}
