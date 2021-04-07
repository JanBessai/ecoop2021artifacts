package interpreter.ep.m6;

import interpreter.ep.m5.AstreeIdzNeg;

public class EqualsNeg extends AstreeIdzNeg implements EqualsExp {

    public EqualsNeg(EqualsExp inner) {
        super(inner);
    }

    public EqualsExp getInner() {
        return (EqualsExp) this.inner;
    }

    public Boolean equals(EqualsExp that) {
        return this.astree().equals(that.astree());
    }
    
    public Boolean isNeg(EqualsExp inner) { 
		return inner.eql(getInner()); 
	}

	public Boolean eql(EqualsExp that) {
		return that.isNeg(getInner());
	}
}
