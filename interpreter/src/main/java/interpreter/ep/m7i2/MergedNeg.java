package interpreter.ep.m7i2;

import interpreter.ep.i1.MultByExp;
import interpreter.ep.m7.PowByExp;
import interpreter.ep.m7.PowByLit;
import interpreter.ep.m7.PowByNeg;

public class MergedNeg extends PowByNeg implements MergedExp {

	public MergedNeg(MergedExp inner) {
		super(inner);
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
		if (getInner().eval().equals(0.0)) {
			return new MergedLit(0.0);
		} else {
			return new MergedNeg((MergedExp) ((MergedExp)inner).simplify());
		}
	}

	public void truncate (int level) {
		if (level > 1) {
			((MergedExp)inner).truncate(level-1);
		} else {
			inner = new MergedLit(inner.eval());
		}
	}
}
