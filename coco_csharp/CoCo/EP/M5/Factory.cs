namespace EP.M5 {
    public interface Factory<FT> : EP.M4.Factory<FT> {
        new Exp<FT> convert(EP.Exp<FT> other);
        EP.M4.Exp<FT> EP.M4.Factory<FT>.convert(EP.Exp<FT> other) { return convert(other); }
    }
}