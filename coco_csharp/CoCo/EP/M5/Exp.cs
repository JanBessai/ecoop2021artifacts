using System.Collections.Generic;

namespace EP.M5 {
    public interface Exp<FT> : Factory<FT>, EP.M4.Exp<FT>  {
        public Tree astree();
        public int id();
    }
}