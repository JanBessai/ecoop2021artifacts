namespace EP.M6 {
    public interface Factory<FT> : EP.M5.Factory<FT> {
        new Exp<FT> convert(EP.Exp<FT> other);
        EP.M5.Exp<FT> EP.M5.Factory<FT>.convert(EP.Exp<FT> other) { return convert(other); }
    }
}