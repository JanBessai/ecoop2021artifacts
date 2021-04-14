package ev.ep.m6;

import ev.ep.Exp;

public class IsSub implements IsDataType {
    Exp left;
    Exp right;

    public IsSub(Exp _left, Exp _right) {
        this.left = _left;
        this.right = _right;
    }

    public Boolean visit(ev.ep.m1.Sub exp) {
        return exp.getLeft().accept(makeEql(left)) && exp.getRight().accept(makeEql(right));
    }

}
