using System;

namespace EP.I1 {
    public interface Lit<FT> : Exp<FT>, EP.M2.Lit<FT> {

        EP.Exp<FT> Exp<FT>.multby(EP.Exp<FT> other) {
            EP.Exp<FT> result = convert(other);
            double counter = Math.Floor(Math.Abs(this.getValue()));
            while (1.0 < counter) {
                result = add(result, convert(other));
                counter = counter - 1.0;
            }
            if (getValue() < 0.0) {
                result = sub(lit(0.0), result);
            }
            return result;
        }
    }
}