namespace EP.M7 {
    public interface Divd<FT> : Exp<FT>, EP.M6.Divd<FT> {
        EP.Exp<FT> Exp<FT>.powby(EP.Exp<FT> other) {
            return divd(convert(getLeft()).powby(convert(other)), convert(getRight()).powby(convert(other)));
        }
    }
}