package interpreter.ep.m7i2;

import static interpreter.ep.m7i2.MergedExpFactory.Neg;
import static interpreter.ep.m7i2.MergedExpFactory.Lit;
import static interpreter.ep.m7i2.MergedExpFactory.Mult;
import static interpreter.ep.m7i2.MergedExpFactory.Power;

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
		return Power(this, (MergedExp)other);
	}

	/** Take advantage of results from both branches. */
	@Override
	public MergedExp multby(MultByExp other) {
        return Mult(this, (MergedExp) other);
    }
	
	public MergedExp simplify() {
		if (getInner().eval() == 0) {
			return Lit(0.0);
		} else {
			return Neg(getInner().simplify());
		}
	}
}
