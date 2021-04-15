package interpreter.ep.m7i2;

import interpreter.ep.i1.MultByExp;
import interpreter.ep.m7.PowByDivd;
import interpreter.ep.m7.PowByExp;

public class MergedDivd extends PowByDivd implements MergedExp {

    public MergedDivd(MergedExp left, MergedExp right) {
        super(left, right);
    }

    public MergedExp simplify() {
        double leftVal = left.eval();
        double rightVal = right.eval();
        if (leftVal == 0) {
            return new MergedLit(0.0);
        } else if (rightVal == 1) {
            return ((MergedExp)left).simplify();
        } else if (leftVal == rightVal) {
            return new MergedLit(1.0);
        } else if (leftVal == -rightVal) {
            return new MergedLit(-1.0);
        } else {
            return new MergedDivd(((MergedExp)left).simplify(), ((MergedExp)right).simplify());
        }
    }

    public void truncate (int level) {
        if (level > 1) {
            ((MergedExp)left).truncate(level-1);
            ((MergedExp)right).truncate(level-1);
        } else {
            left = new MergedLit(left.eval());
            right = new MergedLit(right.eval());
        }
    }

	/** Take advantage of results from both branches. */
	@Override
	public MergedExp powby(PowByExp other) {
		return new MergedPower(this, (MergedExp)other);
	}

	/** Take advantage of results from both branches. */
	@Override
	public MergedExp multby(MultByExp other) {
        return new MergedMult(this, (MergedExp) other);
    }
}
