namespace EP.I1 {
    public interface Exp<FT> : Factory<FT>, EP.M2.Exp<FT>  {
        EP.Exp<FT> multby(EP.Exp<FT> other);
    }
}