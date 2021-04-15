package interpreter.ep.m6;

import interpreter.ep.m5.AstreeIdzLit;

public class EqualsLit extends AstreeIdzLit implements EqualsExp {

    public EqualsLit(Double value) {
        super(value);
    }

    public Boolean equals(EqualsExp that) {
        return this.astree().equals(that.astree());
    }

    public EqualsExp simplify() { return this; }
    
    public Boolean isLit(Double d) { 
		return d.equals(this.value);
	}

	public Boolean eql(EqualsExp that) {
		return that.isLit(getValue());
	}
}
