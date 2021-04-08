package interpreter.ep.m7i2;

import static interpreter.ep.m7i2.MergedExpFactory.*;

import interpreter.ep.i1.MultByExp;
import interpreter.ep.m7.PowByExp;
import interpreter.ep.m7.PowByMult;

public class MergedMult extends PowByMult implements MergedExp {

	public MergedMult(MergedExp left, MergedExp right) {
		super(left, right);
	}

	public MergedExp getLeft() {
		return (MergedExp) this.left;
	}

	public MergedExp getRight() {
		return (MergedExp) this.right;
	}

	/** Take advantage of results from both branches. */
	@Override
	public MergedExp powby(PowByExp other) {
		return power(this, (MergedExp)other);
	}

	/** Take advantage of results from both branches. */
	@Override
	public MergedExp multby(MultByExp other) {
		return mult(this, (MergedExp) other);
	}

	public MergedExp simplify() {
		double leftVal = getLeft().eval();
		double rightVal = getRight().eval();
		if (leftVal == 0 || rightVal == 0) {
			return lit(0.0);
		} else if (leftVal == 1) {
			return getRight().simplify();
		} else if (rightVal == 1) {
			return getLeft().simplify();
		} else {
			return mult(getLeft().simplify(), getRight().simplify());
		}
	}
}
