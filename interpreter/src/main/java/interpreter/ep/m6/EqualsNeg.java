package interpreter.ep.m6;

import interpreter.ep.m5.AstreeIdzNeg;

public class EqualsNeg extends AstreeIdzNeg implements EqualsExp {

    public EqualsNeg(EqualsExp inner) {
        super(inner);
    }

    public Boolean equals(EqualsExp that) {
        return this.astree().equals(that.astree());
    }
    
    public Boolean isNeg(EqualsExp inner) { 
		return inner.eql(inner);
	}

	public Boolean eql(EqualsExp that) {
		return that.isNeg((EqualsExp)inner);
	}

    public EqualsExp simplify() {
        if (inner.eval().equals(0.0)) {
            return new EqualsLit(0.0);
        } else {
            return new EqualsNeg((EqualsExp) ((EqualsExp)inner).simplify());
        }
    }

    public void truncate (int level) {
        if (level > 1) {
            ((EqualsExp)inner).truncate(level-1);
        } else {
            inner = new EqualsLit(inner.eval());
        }
    }
}
