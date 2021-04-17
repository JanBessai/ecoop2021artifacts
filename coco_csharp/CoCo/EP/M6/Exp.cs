namespace EP.M6 {
    public interface Exp<FT> : Factory<FT>, EP.M5.Exp<FT>  {
        bool isLit(double d) { return false; }
        bool isAdd(EP.Exp<FT> left, EP.Exp<FT> right) { return false; }
        bool isSub(EP.Exp<FT> left, EP.Exp<FT> right) { return false; }
        bool isMult(EP.Exp<FT> left, EP.Exp<FT> right) { return false; }
        bool isNeg(EP.Exp<FT> inner) { return false; }
        bool isDivd(EP.Exp<FT> left, EP.Exp<FT> right) { return false; }

        bool equals(EP.Exp<FT> other);
        bool eql(EP.Exp<FT> other);
    }
}