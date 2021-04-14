package interpreter.ep.m7i2;

import static interpreter.ep.m7i2.MergedExpFactory.*;

import interpreter.ep.i1.MultByExp;
import interpreter.ep.m7.PowByExp;
import interpreter.ep.m7.PowByNeg;

public class MergedNeg extends PowByNeg implements MergedExp {

	public MergedNeg(MergedExp inner) {
		super(inner);
	}

	public MergedExp getInner() {
		return (MergedExp) this.inner;
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
		if (getInner().eval().equals(0.0)) {
			return lit(0.0);
		} else {
			return neg(getInner().simplify());
		}
	}
}
