package interpreter.ep.m6;

import interpreter.ep.m5.AstreeIdzSub;

public class EqualsSub extends AstreeIdzSub implements EqualsExp {

    public EqualsSub(EqualsExp left, EqualsExp right) {
        super(left, right);
    }

    public Boolean equals(EqualsExp that) {
        return this.astree().equals(that.astree());
    }
    
    public Boolean isSub(EqualsExp left, EqualsExp right) { 
		return left.eql(left) && right.eql(right);
	}

	public Boolean eql(EqualsExp that) { return that.isSub((EqualsExp)left, (EqualsExp)right); }

    public EqualsExp simplify() {
        if (left.eval().equals(right.eval())) {
            return new EqualsLit(0.0);
        } else {
            return new EqualsSub((EqualsExp) ((EqualsExp)left).simplify(),
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
