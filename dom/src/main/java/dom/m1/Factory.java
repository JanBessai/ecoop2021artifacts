package dom.m1;

public interface Factory<FT> extends dom.m0.Factory<FT> {

    dom.Exp<FT> script(String contents);

    dom.m0.Exp<FT> convert(dom.Exp<FT> toConvert);
}
