namespace EP.M7I2 {
    public interface Lit<FT> : Exp<FT>, EP.M7.Lit<FT>, EP.I1.Lit<FT> {
        EP.Exp<FT> EP.I1.Exp<FT>.multby(EP.Exp<FT> other) {
            return mult(this, convert(other));
        }
        EP.Exp<FT> EP.M7.Exp<FT>.powby(EP.Exp<FT> other) {
            return power(this, convert(other));
        }
    }
}