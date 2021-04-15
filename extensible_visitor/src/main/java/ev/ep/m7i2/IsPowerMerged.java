package ev.ep.m7i2;

import ev.ep.Exp;

public class IsPowerMerged implements IsDataTypeMerged {
    Exp left;
    Exp right;

    public IsPowerMerged(Exp _left, Exp _right) {
       this.left = _left;
       this.right = _right;
    }
    public Boolean visit(ev.ep.i2.Power exp) {
        return exp.getLeft().accept(makeEql(left)) && exp.getRight().accept(makeEql(right));
    }
}
