package interpreter.ep.m5;

import interpreter.ep.m4.CollectSimplifyMult;

public class AstreeIdzMult extends CollectSimplifyMult implements AstreeIdzExp {

    public AstreeIdzMult(AstreeIdzExp left, AstreeIdzExp right) {
        super(left, right);
    }

    public util.Tree astree() {
        return new util.Node(this.idz(), ((AstreeIdzExp)left).astree(), ((AstreeIdzExp)right).astree());
    }

    public Integer idz() {
        return 2409808;
    }

    public AstreeIdzExp  simplify() {
        double leftVal = left.eval();
        double rightVal = right.eval();
        if (leftVal == 0 || rightVal == 0) {
            return new AstreeIdzLit(0.0);
        } else if (leftVal == 1) {
            return ((AstreeIdzExp)right).simplify();
        } else if (rightVal == 1) {
            return ((AstreeIdzExp)left).simplify();
        } else {
            return new AstreeIdzMult(((AstreeIdzExp)left).simplify(), ((AstreeIdzExp)right).simplify());
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
