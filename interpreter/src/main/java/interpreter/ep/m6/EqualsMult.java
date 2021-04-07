package interpreter.ep.m6;

import interpreter.ep.m5.AstreeIdzMult;

public class EqualsMult extends AstreeIdzMult implements EqualsExp {

    public EqualsMult(EqualsExp left, EqualsExp right) {
        super(left, right);
    }

    public EqualsExp getLeft() {
        return (EqualsExp) this.left;
    }

    public EqualsExp getRight() {
        return (EqualsExp) this.right;
    }

    public Boolean equals(EqualsExp that) {
        return this.astree().equals(that.astree());
    }
    
    public Boolean isMult(EqualsExp left, EqualsExp right) { 
		return left.eql(getLeft()) && right.eql(getRight()); 
	}

	public Boolean eql(EqualsExp that) {
		return that.isMult(getLeft(), getRight());
	}
}
