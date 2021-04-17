namespace EP.M1 {
    public interface Sub<FT> : EP.M0.Exp<FT> {

        EP.Exp<FT> getLeft();

        EP.Exp<FT> getRight();

        double EP.M0.Exp<FT>.eval() {
            return convert(getLeft()).eval() - convert(getRight()).eval();
        }
    }
}