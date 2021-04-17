namespace EP.I1 {
    public interface Sub<FT> : Exp<FT>, EP.M2.Sub<FT> {
        EP.Exp<FT> Exp<FT>.multby(EP.Exp<FT> other) {
            return sub(convert(getLeft()).multby(convert(other)), convert(getRight()).multby(convert(other)));
        }
    }
}