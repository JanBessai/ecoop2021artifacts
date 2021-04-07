package dom.m5;

public interface Factory<FT> extends dom.m4.Factory<FT> {
    dom.Exp<FT> table(java.util.List<dom.Exp<FT>> header, java.util.List<java.util.List<dom.Exp<FT>>> rows, java.util.Hashtable<String,String> atts);
    dom.m5.Exp<FT> convert(dom.Exp<FT> other);
}
