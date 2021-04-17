namespace EP.M4 {
    public interface Factory<FT> : EP.M3.Factory<FT> {
        new Exp<FT> convert(EP.Exp<FT> other);
        EP.M2.Exp<FT> EP.M2.Factory<FT>.convert(EP.Exp<FT> other) { return convert(other); }
    }
}