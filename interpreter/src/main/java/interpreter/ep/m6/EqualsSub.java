package interpreter.ep.m6;

import interpreter.ep.m5.AstreeIdzSub;

public class EqualsSub extends AstreeIdzSub implements EqualsExp {

    public EqualsSub(EqualsExp left, EqualsExp right) {
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
    
    public Boolean isSub(EqualsExp left, EqualsExp right) { 
		return left.eql(getLeft()) && right.eql(getRight()); 
	}

	public Boolean eql(EqualsExp that) {
		return that.isSub(getLeft(), getRight());
	}
}
