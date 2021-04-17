namespace EP.M3 {
    public interface Neg<FT> : EP.M2.Exp<FT> {

        EP.Exp<FT> getInner();

        double EP.M0.Exp<FT>.eval() {
            return -1.0 * convert(getInner()).eval();
        }

        string EP.M2.Exp<FT>.prettyp() { return "(-" + convert(getInner()).prettyp() + ")"; }
    }
}