package interpreter.ep.m7i2;

import static interpreter.ep.m7i2.MergedExpFactory.Power;
import static interpreter.ep.m7i2.MergedExpFactory.Sub;
import static interpreter.ep.m7i2.MergedExpFactory.Lit;
import static interpreter.ep.m7i2.MergedExpFactory.Mult;

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
		return Power(this, (MergedExp)other);
	}

	/** Take advantage of results from both branches. */
	@Override
	public MergedExp multby(MultByExp other) {
        return Mult(this, (MergedExp) other);
    }
	
	public MergedExp simplify() {
		if (getLeft().eval() == getRight().eval()) {
			return Lit(0.0);
		} else {
			return Sub(getLeft().simplify(), getRight().simplify());
		}
	}
}
