namespace EP.M0 {
    public interface Factory<FT> : EP.Factory<FT> {
        public EP.Exp<FT> lit(double value);
        public EP.Exp<FT> add(EP.Exp<FT> left, EP.Exp<FT> right);
        
        new Exp<FT> convert(EP.Exp<FT> other);
        EP.Exp<FT> EP.Factory<FT>.convert(EP.Exp<FT> other) { return convert(other); }
    }
}