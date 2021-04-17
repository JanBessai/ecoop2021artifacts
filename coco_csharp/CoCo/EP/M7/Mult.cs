namespace EP.M7 {
    public interface Mult<FT> : Exp<FT>, EP.M6.Mult<FT> {
        EP.Exp<FT> Exp<FT>.powby(EP.Exp<FT> other) {
            return mult(convert(getLeft()).powby(convert(other)), convert(getRight()).powby(convert(other)));
        }
    }
}