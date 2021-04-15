package interpreter.ep.m6;

import interpreter.ep.m5.AstreeIdzAdd;

public class EqualsAdd extends AstreeIdzAdd implements EqualsExp {

	public EqualsAdd(EqualsExp left, EqualsExp right) {
		super(left, right);
	}

	public Boolean equals(EqualsExp that) {
		return this.astree().equals(that.astree());
	}

	public Boolean isAdd(EqualsExp left, EqualsExp right) { 
		return left.eql(left) && right.eql(right);
	}

	public Boolean eql(EqualsExp that) {
		return that.isAdd((EqualsExp)left, (EqualsExp)right);
	}

	public EqualsExp simplify() {
		double leftVal = left.eval();
		double rightVal = right.eval();
		if ((leftVal == 0 && rightVal == 0) || (leftVal + rightVal == 0)) {
			return new EqualsLit(0.0);
		} else if (leftVal == 0) {
			return (EqualsExp) ((EqualsExp)right).simplify();
		} else if (rightVal == 0) {
			return (EqualsExp) ((EqualsExp)left).simplify();
		} else {
			return new EqualsAdd((EqualsExp) ((EqualsExp)left).simplify(),
					(EqualsExp) ((EqualsExp)right).simplify());
		}
	}

	public void truncate (int level) {
		if (level > 1) {
			((EqualsExp)left).truncate(level-1);
			((EqualsExp)right).truncate(level-1);
		} else {
			left = new EqualsLit(left.eval());
			right = new EqualsLit(right.eval());
		}
	}
}
