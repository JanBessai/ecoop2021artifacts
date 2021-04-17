namespace EP.M6 {
    public interface Divd<FT> : Exp<FT>, EP.M5.Divd<FT> {
        bool Exp<FT>.equals(EP.Exp<FT> other) {
            return convert(this).astree().Equals(convert(other).astree());
        }

        bool Exp<FT>.isDivd(EP.Exp<FT> left, EP.Exp<FT> right) {
            return convert(left).eql(getLeft()) && convert(right).eql(getRight());
        }

        bool Exp<FT>.eql(EP.Exp<FT> that) {
            return convert(that).isDivd(convert(getLeft()), convert(getRight()));
        }
    }
}