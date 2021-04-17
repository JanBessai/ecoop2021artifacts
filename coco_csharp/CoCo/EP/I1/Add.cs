namespace EP.I1 {
    public interface Add<FT> : Exp<FT>, EP.M2.Add<FT> {
        EP.Exp<FT> Exp<FT>.multby(EP.Exp<FT> other) {
            return add(convert(getLeft()).multby(convert(other)), convert(getRight()).multby(convert(other)));
        }
    }
}