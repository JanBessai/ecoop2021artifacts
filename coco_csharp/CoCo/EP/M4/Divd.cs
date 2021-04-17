using System.Collections.Generic;

namespace EP.M4 {
    public interface Divd<FT> : Exp<FT>, EP.M3.Divd<FT> {

        public void setLeft(EP.Exp<FT> left);
	    public void setRight(EP.Exp<FT> right);
	
        void Exp<FT>.truncate (int level) {
            if (level > 1) {
                convert(getLeft()).truncate(level-1);
                convert(getRight()).truncate(level-1);
            } else {
                setLeft(lit(convert(getLeft()).eval()));
                setRight(lit(convert(getRight()).eval()));
            }
        }
	
        EP.Exp<FT> Exp<FT>.simplify() {
            if (convert(getLeft()).eval() == (0.0)) {
                return lit(0.0);
            } else if (convert(getRight()).eval() == (1.0)) {
                return convert(getLeft()).simplify();
            } else if (convert(getLeft()).eval() == (convert(getRight()).eval())) {
                return lit(1.0);
            } else if (convert(getLeft()).eval() == (-1.0 * convert(getRight()).eval())) {
                return lit(-1.0);
            } else {
                return divd(convert(getLeft()).simplify(), convert(getRight()).simplify());
            }
        }

        List<double> Exp<FT>.collect() {
            List<double> result = new List<double>();
            result.AddRange(convert(getLeft()).collect());
            result.AddRange(convert(getRight()).collect());
            return result;
        }
    }
}