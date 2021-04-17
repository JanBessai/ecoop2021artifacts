namespace EP.M6 {
    public interface Add<FT> : Exp<FT>, EP.M5.Add<FT> {
        bool Exp<FT>.equals(EP.Exp<FT> other) {
            return convert(this).astree().Equals(convert(other).astree());
        }

        bool Exp<FT>.isAdd(EP.Exp<FT> left, EP.Exp<FT> right) {
            return convert(left).eql(getLeft()) && convert(right).eql(getRight());
        }

        bool Exp<FT>.eql(EP.Exp<FT> that) {
            return convert(that).isAdd(convert(getLeft()), convert(getRight()));
        }
    }
}