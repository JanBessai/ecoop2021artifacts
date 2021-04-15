package interpreter.ep.m7;

import interpreter.ep.m6.EqualsSub;

public class PowBySub extends EqualsSub implements PowByExp {

    public PowBySub(PowByExp left, PowByExp right) {
		super(left, right);
	}

	public PowByExp powby(PowByExp other) {
        return new PowByLit(this.eval()).powby(other);
    }

    public PowByExp simplify() {
        if (left.eval().equals(right.eval())) {
            return new PowByLit(0.0);
        } else {
            return new PowBySub(((PowByExp)left).simplify(),
                                ((PowByExp)right).simplify());
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
