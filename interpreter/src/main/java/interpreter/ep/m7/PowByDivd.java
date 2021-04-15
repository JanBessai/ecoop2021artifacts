package interpreter.ep.m7;

import interpreter.ep.m4.CollectSimplifyExp;
import interpreter.ep.m6.EqualsDivd;

public class PowByDivd extends EqualsDivd implements PowByExp {

    public PowByDivd(PowByExp left, PowByExp right) {
		super(left, right);
	}

	public PowByExp powby(PowByExp other) {
        return new PowByDivd(((PowByExp)left).powby(other), ((PowByExp)right).powby(other));
    }

    public PowByExp simplify() {
        double leftVal = left.eval();
        double rightVal = right.eval();
        if (leftVal == 0) {
            return new PowByLit(0.0);
        } else if (rightVal == 1) {
            return (PowByExp) ((CollectSimplifyExp)left).simplify();
        } else if (leftVal == rightVal) {
            return new PowByLit(1.0);
        } else if (leftVal == -rightVal) {
            return new PowByLit(-1.0);
        } else {
            return new PowByDivd ((PowByExp) ((CollectSimplifyExp)left).simplify(), (PowByExp) ((CollectSimplifyExp)right).simplify());
        }
    }

    public void truncate (int level) {
        if (level > 1) {
            ((PowByExp)left).truncate(level-1);
            ((PowByExp)right).truncate(level-1);
        } else {
            left = new PowByLit(left.eval());
            right = new PowByLit(right.eval());
        }
    }
}
