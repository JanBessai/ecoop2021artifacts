namespace EP.M7 {
    public interface Neg<FT> : Exp<FT>, EP.M6.Neg<FT> {
        EP.Exp<FT> Exp<FT>.powby(EP.Exp<FT> other) {
            return mult(convert(lit(1.0)).powby(getInner()), convert(getInner()).powby(convert(other)));
        }
    }
}