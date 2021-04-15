package interpreter.ep.m6;

import interpreter.ep.m5.AstreeIdzDivd;

public class EqualsDivd extends AstreeIdzDivd implements EqualsExp {

    public EqualsDivd(EqualsExp left, EqualsExp right) {
        super(left, right);
    }

    public Boolean equals(EqualsExp that) {
        return this.astree().equals(that.astree());
    }
    
    public Boolean isDivd(EqualsExp left, EqualsExp right) { return left.eql(left) && right.eql(right); }

	public Boolean eql(EqualsExp that) { return that.isDivd((EqualsExp)left, (EqualsExp)right); }

    public EqualsExp simplify() {
        double leftVal = left.eval();
        double rightVal = right.eval();
        if (leftVal == 0) {
            return new EqualsLit(0.0);
        } else if (rightVal == 1) {
            return (EqualsExp) ((EqualsExp)left).simplify();
        } else if (leftVal == rightVal) {
            return new EqualsLit(1.0);
        } else if (leftVal == -rightVal) {
            return new EqualsLit(-1.0);
        } else {
            return new EqualsDivd ((EqualsExp) ((EqualsExp)left).simplify(), (EqualsExp) ((EqualsExp)right).simplify());
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
