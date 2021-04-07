package interpreter.ep.m7i2;

import static interpreter.ep.m7i2.MergedExpFactory.Lit;
import static interpreter.ep.m7i2.MergedExpFactory.Divd;
import static interpreter.ep.m7i2.MergedExpFactory.Mult;
import static interpreter.ep.m7i2.MergedExpFactory.Power;

import interpreter.ep.i1.MultByExp;
import interpreter.ep.m7.PowByDivd;
import interpreter.ep.m7.PowByExp;

public class MergedDivd extends PowByDivd implements MergedExp {

    public MergedDivd(MergedExp left, MergedExp right) {
        super(left, right);
    }

    public MergedExp getLeft() {
        return (MergedExp) this.left;
    }

    public MergedExp getRight() {
        return (MergedExp) this.right;
    }

    public MergedExp simplify() {
        double leftVal = getLeft().eval();
        double rightVal = getRight().eval();
        if (leftVal == 0) {
            return Lit(0.0);
        } else if (rightVal == 1) {
            return getLeft().simplify();
        } else if (leftVal == rightVal) {
            return Lit(1.0);
        } else if (leftVal == -rightVal) {
            return Lit(-1.0);
        } else {
            return Divd(getLeft().simplify(), getRight().simplify());
        }
    }
    
	/** Take advantage of results from both branches. */
	@Override
	public MergedExp powby(PowByExp other) {
		return Power(this, (MergedExp)other);
	}

	/** Take advantage of results from both branches. */
	@Override
	public MergedExp multby(MultByExp other) {
        return Mult(this, (MergedExp) other);
    }
}
