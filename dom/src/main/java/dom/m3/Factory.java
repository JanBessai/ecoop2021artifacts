package dom.m3;

public interface Factory<FT> extends dom.m2.Factory<FT> {

    dom.m3.Exp<FT> convert(dom.Exp<FT> other);
}
