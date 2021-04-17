namespace EP.M6 {
    public interface Mult<FT> : Exp<FT>, EP.M5.Mult<FT> {
        bool Exp<FT>.equals(EP.Exp<FT> other) {
            return convert(this).astree().Equals(convert(other).astree());
        }

        bool Exp<FT>.isMult(EP.Exp<FT> left, EP.Exp<FT> right) {
            return convert(left).eql(getLeft()) && convert(right).eql(getRight());
        }

        bool Exp<FT>.eql(EP.Exp<FT> that) {
            return convert(that).isMult(convert(getLeft()), convert(getRight()));
        }
    }
}