package interpreter.ep.m7i2;

import interpreter.ep.m7.PowByAdd;
import interpreter.ep.m7.PowByExp;

import interpreter.ep.i1.MultByExp;

/** This could have chosen either branch to extend, since Add defined before split. */
public class MergedAdd extends PowByAdd implements MergedExp {

    public MergedAdd(MergedExp left, MergedExp right) {
        super(left, right);
    }

    @Override
    public MergedExp simplify() {
        double leftVal = left.eval();
        double rightVal = right.eval();
        if ((leftVal == 0 && rightVal == 0) || (leftVal + rightVal == 0)) {
            return new MergedLit(0.0);
        } else if (leftVal == 0) {
            return ((MergedExp)left).simplify();
        } else if (rightVal == 0) {
            return ((MergedExp)right).simplify();
        } else {
            return new MergedAdd( ((MergedExp)left).simplify(), ((MergedExp)right).simplify());
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
