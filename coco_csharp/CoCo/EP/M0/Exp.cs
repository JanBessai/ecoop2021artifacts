namespace EP.M0 {
    public interface Exp<FT> : EP.Exp<FT>, Factory<FT> {
        public double eval();
    }
}