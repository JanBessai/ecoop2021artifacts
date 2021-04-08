package interpreter.ep.m7i2;

import static interpreter.ep.m7i2.MergedExpFactory.*;

import interpreter.ep.i1.MultByExp;
import interpreter.ep.m7.PowByExp;
import interpreter.ep.m7.PowBySub;

public class MergedSub extends PowBySub implements MergedExp {

	public MergedSub(MergedExp left, MergedExp right) {
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
		if (getLeft().eval() == getRight().eval()) {
			return lit(0.0);
		} else {
			return sub(getLeft().simplify(), getRight().simplify());
		}
	}
}
