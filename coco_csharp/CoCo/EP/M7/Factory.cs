namespace EP.M7 {
    public interface Factory<FT> : EP.M6.Factory<FT> {
        new Exp<FT> convert(EP.Exp<FT> other);
        EP.M6.Exp<FT> EP.M6.Factory<FT>.convert(EP.Exp<FT> other) { return convert(other); }
    }
}