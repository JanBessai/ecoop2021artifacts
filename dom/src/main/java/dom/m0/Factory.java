package dom.m0;

public interface Factory<FT> extends dom.Factory<FT> {

    dom.Exp<FT> tag(String name, String contents, java.util.Hashtable<String,String> atts);
    dom.Exp<FT> tag(String name, String contents);

    dom.Exp<FT> block(java.util.List<dom.Exp<FT>> tags);

    dom.Exp<FT> document(dom.Exp<FT> head, dom.Exp<FT> body);

    dom.m0.Exp<FT> convert(dom.Exp<FT> other);
}
