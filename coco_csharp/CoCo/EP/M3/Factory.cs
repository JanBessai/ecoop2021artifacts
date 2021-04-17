namespace EP.M3 {
    public interface Factory<FT> : EP.M2.Factory<FT> {
        public EP.Exp<FT> neg(EP.Exp<FT> inner);
        public EP.Exp<FT> mult(EP.Exp<FT> left, EP.Exp<FT> right);
        public EP.Exp<FT> divd(EP.Exp<FT> left, EP.Exp<FT> right);
    }
}