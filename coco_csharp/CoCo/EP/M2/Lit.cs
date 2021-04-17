namespace EP.M2 {
    public interface Lit<FT> : Exp<FT>, EP.M0.Lit<FT> {

        string Exp<FT>.prettyp() { return "" + this.getValue(); }
    }
}