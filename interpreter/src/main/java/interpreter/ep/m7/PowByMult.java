package interpreter.ep.m7;

import interpreter.ep.m6.EqualsMult;

public class PowByMult extends EqualsMult implements PowByExp {

    public PowByMult(PowByExp left, PowByExp right) {
		super(left, right);
	}

	public PowByExp powby(PowByExp other) {
        return new PowByMult(((PowByExp)left).powby(other), ((PowByExp)right).powby(other));
    }

    public PowByExp simplify() {
        double leftVal = left.eval();
        double rightVal = right.eval();
        if (leftVal == 0 || rightVal == 0) {
            return new PowByLit(0.0);
        } else if (leftVal == 1) {
            return ((PowByExp)right).simplify();
        } else if (rightVal == 1) {
            return  ((PowByExp)left).simplify();
        } else {
            return new PowByMult(((PowByExp)left).simplify(),  ((PowByExp)right).simplify());
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
