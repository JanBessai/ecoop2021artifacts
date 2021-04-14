package ev.ep.m6;

import ev.ep.Exp;

public class IsAdd implements IsDataType {
    Exp left;
    Exp right;

    public IsAdd(Exp _left, Exp _right) {
        this.left = _left;
        this.right = _right;
    }

    public Boolean visit(ev.ep.m0.Add exp) {
        return exp.getLeft().accept(makeEql(left)) && exp.getRight().accept(makeEql(right));
    }

}
