namespace EP.M2 {
    public interface Factory<FT> : EP.M1.Factory<FT> {
        new Exp<FT> convert(EP.Exp<FT> other);
        EP.M0.Exp<FT> EP.M0.Factory<FT>.convert(EP.Exp<FT> other) { return convert(other); }
    }
}