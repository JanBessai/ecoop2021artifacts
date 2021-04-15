package interpreter.ep.m5;

import interpreter.ep.m4.CollectSimplifySub;

public class AstreeIdzSub extends CollectSimplifySub implements AstreeIdzExp {

    public AstreeIdzSub(AstreeIdzExp left, AstreeIdzExp right) {
        super(left, right);
    }

    public util.Tree astree() { return new util.Node(this.idz(), ((AstreeIdzExp)left).astree(), ((AstreeIdzExp)right).astree()); }

    public Integer idz() {
        return 83488;
    }

    public AstreeIdzExp simplify() {
        if (left.eval().equals(right.eval())) {
            return new AstreeIdzLit(0.0);
        } else {
            return new AstreeIdzSub((AstreeIdzExp) ((AstreeIdzExp)left).simplify(),
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
