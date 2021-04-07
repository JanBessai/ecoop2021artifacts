package dom.m2;

public interface Factory<FT> extends dom.m1.Factory<FT> {

    dom.Exp<FT> runnableElement(IGenerateOutput runnable);

    dom.m0.Exp<FT> convert(dom.Exp<FT> toConvert);
}
