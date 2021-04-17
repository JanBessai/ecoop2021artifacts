using System.Collections.Generic;

namespace EP.M4 {
    public interface Exp<FT> : Factory<FT>, EP.M2.Exp<FT>  {
        public EP.Exp<FT> simplify();
        public void truncate(int level);
        public List<double> collect();
    }
}