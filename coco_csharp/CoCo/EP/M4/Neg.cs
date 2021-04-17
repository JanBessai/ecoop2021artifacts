using System.Collections.Generic;

namespace EP.M4 {
    public interface Neg<FT> : Exp<FT>, EP.M3.Neg<FT> {

        public void setInner(EP.Exp<FT> inner);
	
        void Exp<FT>.truncate (int level) {
            if (level > 1) {
                convert(getInner()).truncate(level-1);
            } else {
                setInner(lit(convert(getInner()).eval()));
            }
        }
	
        EP.Exp<FT> Exp<FT>.simplify() {
            if (convert(getInner()).eval() == (0.0)) {
                return lit(0.0);
            } else {
                return neg(convert(getInner()).simplify());
            }
        }

        List<double> Exp<FT>.collect() {
            List<double> result = new List<double>();
            result.AddRange(convert(getInner()).collect());
            return result;
        }
    }
}