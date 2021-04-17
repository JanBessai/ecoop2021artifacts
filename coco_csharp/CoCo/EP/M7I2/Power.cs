using System.Collections.Generic;

namespace EP.M7I2 {
    public interface Power<FT> : Exp<FT>, EP.I2.Power<FT> {
        void setLeft(EP.Exp<FT> left);
        void setRight(EP.Exp<FT> right);

         EP.Exp<FT> EP.I1.Exp<FT>.multby(EP.Exp<FT> other) {return mult(this, convert(other)); }
         EP.Exp<FT> EP.M7.Exp<FT>.powby(EP.Exp<FT> other) {
            return power(this, convert(other));
        }

         void EP.M4.Exp<FT>.truncate (int level) {
            if (level > 1) {
                convert(getLeft()).truncate(level-1);
                convert(getRight()).truncate(level-1);
            } else {
                setLeft(lit(convert(getLeft()).eval()));
                setRight(lit(convert(getRight()).eval()));
            }
        }
        
        EP.Exp<FT> EP.M4.Exp<FT>.simplify() {
            if (convert(getRight()).eval() == (0.0)) {
                return lit(1.0);
            } else if (convert(getLeft()).eval() == (1.0)) {
                return lit(1.0);
            } else if (convert(getRight()).eval() == (1.0)) {
                return convert(getLeft()).simplify();
            } else {
                return power(convert(getLeft()).simplify(), convert(getRight()).simplify());
            }
        }

        List<double> EP.M4.Exp<FT>.collect() {
            List<double> result = new List<double>();
            result.AddRange(convert(getLeft()).collect());
            result.AddRange(convert(getRight()).collect());
            return result;
        }

        EP.M5.Tree EP.M5.Exp<FT>.astree() {
            return new M5.Node(convert(this).id(), convert(getLeft()).astree(), convert(getRight()).astree());
        }

        int EP.M5.Exp<FT>.id() {
            return 77306085;
        }

        bool EP.M6.Exp<FT>.equals(EP.Exp<FT> other) {
            return convert(this).astree().Equals(convert(other).astree());
        }

        bool EP.M7I2.Exp<FT>.isPower(EP.Exp<FT> left, EP.Exp<FT> right) {
            return convert(left).eql(getLeft()) && convert(right).eql(getRight());
        }

        bool EP.M6.Exp<FT>.eql(EP.Exp<FT> that) {
            return convert(that).isPower(convert(getLeft()), convert(getRight()));
        }
    }
}