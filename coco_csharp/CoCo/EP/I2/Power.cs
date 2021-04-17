using System;

namespace EP.I2 {
    public interface Power<FT> : EP.I1.Exp<FT>, Factory<FT> {

        EP.Exp<FT> getLeft();

        EP.Exp<FT> getRight();

        double EP.M0.Exp<FT>.eval() {
            return Math.Pow(convert(getLeft()).eval(), convert(getRight()).eval());
        }

        EP.Exp<FT> EP.I1.Exp<FT>.multby(EP.Exp<FT> other) {
            double leftEval = convert(getLeft()).eval();
            double added = Math.Log(convert(other).eval()) / Math.Log(leftEval);
            return power(getLeft(), add(getRight(), lit(added)));
        }

        string EP.M2.Exp<FT>.prettyp() { return "(" + convert(getLeft()).prettyp() + "^" + convert(getRight()).prettyp() + ")"; }
    }
}