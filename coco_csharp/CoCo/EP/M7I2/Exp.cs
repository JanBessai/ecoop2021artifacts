namespace EP.M7I2 {
    public interface Exp<FT> : Factory<FT>, EP.M7.Exp<FT>, EP.I1.Exp<FT> {
        bool isPower(EP.Exp<FT> left, EP.Exp<FT> right) { return false; }
    }
}