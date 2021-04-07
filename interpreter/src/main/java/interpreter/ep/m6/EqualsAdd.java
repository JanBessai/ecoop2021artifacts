package interpreter.ep.m6;

import interpreter.ep.m5.AstreeIdzAdd;

public class EqualsAdd extends AstreeIdzAdd implements EqualsExp {

	public EqualsAdd(EqualsExp left, EqualsExp right) {
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

	public Boolean isAdd(EqualsExp left, EqualsExp right) { 
		return left.eql(getLeft()) && right.eql(getRight()); 
	}

	public Boolean eql(EqualsExp that) {
		return that.isAdd(getLeft(), getRight());
	}
}
