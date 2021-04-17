namespace EP.M0 {
    public interface Add<FT> : Exp<FT> {

        EP.Exp<FT> getLeft();

        EP.Exp<FT> getRight();

        double Exp<FT>.eval() {
            return convert(getLeft()).eval() + convert(getRight()).eval();
        }
    }
}