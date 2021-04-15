package interpreter.ep.m7i2;

import interpreter.ep.m7.PowByExp;
import interpreter.ep.m7.PowByLit;
import interpreter.ep.i1.MultByExp;

/** Must reimplement one of the branches -- pick smallest one to do this work. */
public class MergedLit extends PowByLit implements MergedExp {

    public MergedLit(Double value) {
    	super(value);
    }

    public Double getValue() {
        return this.value;
    }

    public MergedExp simplify() {
        return this;
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
