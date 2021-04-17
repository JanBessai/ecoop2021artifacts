namespace EP.M1 {
    public interface Factory<FT> : EP.M0.Factory<FT> {
        public EP.Exp<FT> sub(EP.Exp<FT> left, EP.Exp<FT> right);
    }
}