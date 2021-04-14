package trivially.ep.m3.finalized;

import trivially.ep.m2.Exp;

public class Neg implements trivially.ep.m3.Neg {

    protected Exp inner;

    public Exp getInner() {
        return this.inner;
    }

    public Neg(Exp inner) {
        this.inner = inner;
    }
}
