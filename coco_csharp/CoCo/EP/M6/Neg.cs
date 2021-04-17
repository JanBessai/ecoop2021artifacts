namespace EP.M6 {
    public interface Neg<FT> : Exp<FT>, EP.M5.Neg<FT> {
        bool Exp<FT>.equals(EP.Exp<FT> other) {
            return convert(this).astree().Equals(convert(other).astree());
        }

        bool Exp<FT>.isNeg(EP.Exp<FT> inner) {
            return convert(inner).eql(getInner());
        }

        bool Exp<FT>.eql(EP.Exp<FT> that) {
            return convert(that).isNeg(getInner());
        }
    }
}