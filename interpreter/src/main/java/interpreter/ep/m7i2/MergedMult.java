package interpreter.ep.m7i2;

import interpreter.ep.i1.MultByExp;
import interpreter.ep.m7.PowByExp;
import interpreter.ep.m7.PowByMult;

public class MergedMult extends PowByMult implements MergedExp {

	public MergedMult(MergedExp left, MergedExp right) {
		super(left, right);
	}

	public MergedExp simplify() {
		double leftVal = left.eval();
		double rightVal = right.eval();
		if (leftVal == 0 || rightVal == 0) {
			return new MergedLit(0.0);
		} else if (leftVal == 1) {
			return (MergedExp) ((MergedExp)right).simplify();
		} else if (rightVal == 1) {
			return (MergedExp) ((MergedExp)left).simplify();
		} else {
			MergedExp mleft = (MergedExp) ((MergedExp)left).simplify();
			MergedExp mright = (MergedExp) ((MergedExp)right).simplify();
			return new MergedMult(mleft, mright);
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
