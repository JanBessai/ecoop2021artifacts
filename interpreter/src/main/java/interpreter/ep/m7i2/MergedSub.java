package interpreter.ep.m7i2;

import interpreter.ep.i1.MultByExp;
import interpreter.ep.m7.PowByExp;
import interpreter.ep.m7.PowBySub;

public class MergedSub extends PowBySub implements MergedExp {

	public MergedSub(MergedExp left, MergedExp right) {
		super(left, right);
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
	
	public MergedExp simplify() {
		if (left.eval().equals(right.eval())) {
			return new MergedLit(0.0);
		} else {
			return new MergedSub( ((MergedExp)left).simplify(), ((MergedExp)right).simplify());
		}
	}
}
