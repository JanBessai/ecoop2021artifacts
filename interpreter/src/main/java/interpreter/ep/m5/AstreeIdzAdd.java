package interpreter.ep.m5;

import interpreter.ep.m4.CollectSimplifyAdd;

public class AstreeIdzAdd extends CollectSimplifyAdd implements AstreeIdzExp {

    public AstreeIdzAdd(AstreeIdzExp left, AstreeIdzExp right) {
        super(left, right);
    }

    public util.Tree astree() {
        return new util.Node(this.idz(), ((AstreeIdzExp)left).astree(), ((AstreeIdzExp)right).astree());
    }

    public Integer idz() {
        return 65665;
    }

    public AstreeIdzExp simplify() {
        double leftVal = left.eval();
        double rightVal = right.eval();
        if ((leftVal == 0 && rightVal == 0) || (leftVal + rightVal == 0)) {
            return new AstreeIdzLit(0.0);
        } else if (leftVal == 0) {
            return (AstreeIdzExp) ((AstreeIdzExp)right).simplify();
        } else if (rightVal == 0) {
            return (AstreeIdzExp) ((AstreeIdzExp)left).simplify();
        } else {
            return new AstreeIdzAdd((AstreeIdzExp) ((AstreeIdzExp)left).simplify(),
                                    (AstreeIdzExp) ((AstreeIdzExp)right).simplify());
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
