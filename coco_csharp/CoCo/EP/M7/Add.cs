namespace EP.M7 {
    public interface Add<FT> : Exp<FT>, EP.M6.Add<FT> {
        EP.Exp<FT> Exp<FT>.powby(EP.Exp<FT> other) {
            return convert(lit(convert(this).eval())).powby(convert(other));
        }
    }
}