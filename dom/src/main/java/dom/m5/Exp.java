package dom.m5;

public interface Exp<FT> extends Factory<FT>, dom.m3.Exp<FT> {

    dom.Exp<FT> reduce();
}
