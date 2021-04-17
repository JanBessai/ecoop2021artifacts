using System;

namespace EP.M7 {
    public interface Lit<FT> : Exp<FT>, EP.M6.Lit<FT> {
        EP.Exp<FT> Exp<FT>.powby(EP.Exp<FT> other) {
            double exponentValue = convert(other).eval();
            Exp<FT> result = this;
            double counter = Math.Floor(Math.Abs(exponentValue));
            while (1.0 < counter) {
                result = convert(mult(result, this));
                counter = counter - 1.0;
            }
            if (getValue() < 0.0) {
                result = convert(divd(lit(1.0), result));
            }
            return result;
        }
    }
}