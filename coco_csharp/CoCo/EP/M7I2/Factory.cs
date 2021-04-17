namespace EP.M7I2 {
    public interface Factory<FT> : EP.M7.Factory<FT>, EP.I2.Factory<FT> {
        new Exp<FT> convert(EP.Exp<FT> other);

        // Need to disambiguate *SPLIT* and *MERGE* points.
        EP.M2.Exp<FT> EP.M2.Factory<FT>.convert(EP.Exp<FT> other) { return convert(other); }
        EP.M7.Exp<FT> EP.M7.Factory<FT>.convert(EP.Exp<FT> other) { return convert(other); }
        EP.I1.Exp<FT> EP.I1.Factory<FT>.convert(EP.Exp<FT> other) { return convert(other); }
    }
}