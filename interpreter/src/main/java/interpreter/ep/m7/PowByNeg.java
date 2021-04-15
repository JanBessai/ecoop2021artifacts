package interpreter.ep.m7;

import interpreter.ep.m6.EqualsNeg;

public class PowByNeg extends EqualsNeg implements PowByExp {

    public PowByNeg(PowByExp inner) {
		super(inner);
	}
    
    public PowByExp getInner() {
        return (PowByExp) this.inner;
    }

	public PowByExp powby(PowByExp other) { return new PowByMult(new PowByLit(1.0).powby(getInner()), getInner().powby(other)); }

    public PowByExp simplify() {
        if (inner.eval().equals(0.0)) {
            return new PowByLit(0.0);
        } else {
            return new PowByNeg( ((PowByExp)inner).simplify());
        }
    }

    public void truncate (int level) {
        if (level > 1) {
            ((PowByExp)inner).truncate(level-1);
        } else {
            inner = new PowByLit(inner.eval());
        }
    }
}
