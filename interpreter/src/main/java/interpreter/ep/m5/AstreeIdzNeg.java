package interpreter.ep.m5;

import interpreter.ep.m4.CollectSimplifyNeg;

public class AstreeIdzNeg extends CollectSimplifyNeg implements AstreeIdzExp {

    public AstreeIdzNeg(AstreeIdzExp inner) {
        super(inner);
    }

    public AstreeIdzExp getInner() { return (AstreeIdzExp) this.inner; }

    public util.Tree astree() { return new util.Node(this.idz(), getInner().astree()); }

    public Integer idz() {
        return 78192;
    }
}
