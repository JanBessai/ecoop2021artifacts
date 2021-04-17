namespace EP.M7I2 {
    public interface Mult<FT> : Exp<FT>, EP.M7.Mult<FT> {
        EP.Exp<FT> EP.I1.Exp<FT>.multby(EP.Exp<FT> other) {
            return mult(this, convert(other));
        }
        EP.Exp<FT> EP.M7.Exp<FT>.powby(EP.Exp<FT> other) {
            return power(this, convert(other));
        }
    }
}