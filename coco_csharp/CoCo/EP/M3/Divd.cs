namespace EP.M3 {
    public interface Divd<FT> : EP.M2.Exp<FT> {

        EP.Exp<FT> getLeft();

        EP.Exp<FT> getRight();

        double EP.M0.Exp<FT>.eval() {
            return convert(getLeft()).eval() / convert(getRight()).eval();
        }

        string EP.M2.Exp<FT>.prettyp() { return "(" + convert(getLeft()).prettyp() + "/" + convert(getRight()).prettyp() + ")"; }
    }
}