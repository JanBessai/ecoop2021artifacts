package dom.m4;

public interface Factory<FT> extends dom.m3.Factory<FT> {
    dom.Exp<FT> list(java.util.List<dom.Exp<FT>> items);

    dom.m3.Exp<FT> convert(dom.Exp<FT> other);
}
