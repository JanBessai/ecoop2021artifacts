namespace EP.M2 {
    public interface Sub<FT> : Exp<FT>, EP.M1.Sub<FT> {
       string Exp<FT>.prettyp() { return "(" + convert(getLeft()).prettyp() + "-" + convert(getRight()).prettyp() + ")"; }
    }
}