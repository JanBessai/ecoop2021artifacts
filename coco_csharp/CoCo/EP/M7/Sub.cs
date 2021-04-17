namespace EP.M7 {
    public interface Sub<FT> : Exp<FT>, EP.M6.Sub<FT> {
        EP.Exp<FT> Exp<FT>.powby(EP.Exp<FT> other) {
            return convert(lit(convert(this).eval())).powby(convert(other));
        }
    }
}