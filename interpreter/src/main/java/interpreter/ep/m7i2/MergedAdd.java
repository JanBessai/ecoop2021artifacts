package interpreter.ep.m7i2;

import interpreter.ep.m7.PowByAdd;
import interpreter.ep.m7.PowByExp;

import static interpreter.ep.m7i2.MergedExpFactory.Add;
import static interpreter.ep.m7i2.MergedExpFactory.Lit;
import static interpreter.ep.m7i2.MergedExpFactory.Mult;
import static interpreter.ep.m7i2.MergedExpFactory.Power;

import interpreter.ep.i1.MultByExp;

/** This could have chosen either branch to extend, since Add defined before split. */
public class MergedAdd extends PowByAdd implements MergedExp {

    public MergedAdd(MergedExp left, MergedExp right) {
        super(left, right);
    }

    public MergedExp getLeft() {
        return (MergedExp) this.left;
    }

    public MergedExp getRight() {
        return (MergedExp) this.right;
    }
    
    @Override
    public MergedExp simplify() {
        double leftVal = getLeft().eval();
        double rightVal = getRight().eval();
        if ((leftVal == 0 && rightVal == 0) || (leftVal + rightVal == 0)) {
            return Lit(0.0);
        } else if (leftVal == 0) {
            return getRight().simplify();
        } else if (rightVal == 0) {
            return getLeft().simplify();
        } else {
            return Add(getLeft().simplify(), getRight().simplify());
        }
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
