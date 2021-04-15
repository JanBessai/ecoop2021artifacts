package interpreter.ep.m5;

import interpreter.ep.m4.CollectSimplifyDivd;

public class AstreeIdzDivd extends CollectSimplifyDivd implements AstreeIdzExp {

    public AstreeIdzDivd(AstreeIdzExp left, AstreeIdzExp right) {
        super(left, right);
    }

    public util.Tree astree() {
        return new util.Node(this.idz(), ((AstreeIdzExp)left).astree(), ((AstreeIdzExp)right).astree());
    }

    public Integer idz() {
        return 2130451;
    }

    public AstreeIdzExp  simplify() {
        double leftVal = left.eval();
        double rightVal = right.eval();
        if (leftVal == 0) {
            return new AstreeIdzLit(0.0);
        } else if (rightVal == 1) {
            return  ((AstreeIdzExp)left).simplify();
        } else if (leftVal == rightVal) {
            return new AstreeIdzLit(1.0);
        } else if (leftVal == -rightVal) {
            return new AstreeIdzLit(-1.0);
        } else {
            return new AstreeIdzDivd (((AstreeIdzExp)left).simplify(), ((AstreeIdzExp)right).simplify());
        }
    }

    public void truncate (int level) {
        if (level > 1) {
            ((AstreeIdzExp)left).truncate(level-1);
            ((AstreeIdzExp)right).truncate(level-1);
        } else {
            left = new AstreeIdzLit(left.eval());
            right = new AstreeIdzLit(right.eval());
        }
    }
}
