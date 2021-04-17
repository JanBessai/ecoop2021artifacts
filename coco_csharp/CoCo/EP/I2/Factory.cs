namespace EP.I2 {
    public interface Factory<FT> : EP.I1.Factory<FT> {
        public EP.Exp<FT> power(EP.Exp<FT> left, EP.Exp<FT> right);
    }
}