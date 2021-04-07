package interpreter.ep.m7i2;

import interpreter.ep.m7.PowByExp;
import interpreter.ep.m7.PowByLit;
import interpreter.ep.i1.MultByExp;

import static interpreter.ep.m7i2.MergedExpFactory.Lit;
import static interpreter.ep.m7i2.MergedExpFactory.Mult;
import static interpreter.ep.m7i2.MergedExpFactory.Power;

/** Must reimplement one of the branches -- pick smallest one to do this work. */
public class MergedLit extends PowByLit implements MergedExp {

    public MergedLit(Double value) {
    	super(value);
    }

    public Double getValue() {
        return this.value;
    }

    public MergedExp simplify() {
        return Lit(getValue());
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

}
