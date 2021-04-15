package interpreter.ep.m5;

import interpreter.ep.m4.CollectSimplifyNeg;

public class AstreeIdzNeg extends CollectSimplifyNeg implements AstreeIdzExp {

    public AstreeIdzNeg(AstreeIdzExp inner) {
        super(inner);
    }

    public util.Tree astree() { return new util.Node(this.idz(), ((AstreeIdzExp)inner).astree()); }

    public Integer idz() {
        return 78192;
    }

    public AstreeIdzExp simplify() {
        if (inner.eval().equals(0.0)) {
            return new AstreeIdzLit(0.0);
        } else {
            return new AstreeIdzNeg( ((AstreeIdzExp)inner).simplify());
        }
    }

    public void truncate (int level) {
        if (level > 1) {
            ((AstreeIdzExp)inner).truncate(level-1);
        } else {
            inner = new AstreeIdzLit(inner.eval());
        }
    }
}
