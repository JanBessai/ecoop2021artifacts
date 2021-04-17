namespace EP.M2 {
    public interface Add<FT> : Exp<FT>, EP.M0.Add<FT> {

        string Exp<FT>.prettyp() { return "(" + convert(getLeft()).prettyp() + "+" + convert(getRight()).prettyp() + ")"; }
    }
}