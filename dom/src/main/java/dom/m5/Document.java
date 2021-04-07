package dom.m5;

public interface Document<FT> extends Exp<FT>, dom.m3.Document<FT> {
	default dom.Exp<FT> reduce() {
		return document(convert(getHead()).reduce(), convert(getBody()).reduce());
	}
}
