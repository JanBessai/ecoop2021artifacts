package ev.ep.m6;

import ev.ep.Exp;

public class IsMult implements IsDataType {
    Exp left;
    Exp right;

    public IsMult(Exp _left, Exp _right) {
        this.left = _left;
        this.right = _right;
    }

    public Boolean visit(ev.ep.m3.Mult exp) {
        return exp.getLeft().accept(makeEql(left)) && exp.getRight().accept(makeEql(right));
    }

}
