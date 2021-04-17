namespace EP.M6 {
    public interface Lit<FT> : Exp<FT>, EP.M5.Lit<FT> {
        bool Exp<FT>.equals(EP.Exp<FT> other) {
            return convert(this).astree().Equals(convert(other).astree());
        }

        bool Exp<FT>.isLit(double d) {
            return d == getValue();
        }

        bool Exp<FT>.eql(EP.Exp<FT> that) {
            return convert(that).isLit(getValue());
        }
    }
}