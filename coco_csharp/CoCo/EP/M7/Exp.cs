namespace EP.M7 {
    public interface Exp<FT> : Factory<FT>, EP.M6.Exp<FT>  {
        EP.Exp<FT> powby(EP.Exp<FT> other);
    }
}