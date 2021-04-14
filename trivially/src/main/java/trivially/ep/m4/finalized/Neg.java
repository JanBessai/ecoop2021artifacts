package trivially.ep.m4.finalized;

import trivially.ep.m4.Exp;

public class Neg implements trivially.ep.m4.Neg {

    protected Exp inner;

    public Exp getInner() {
        return this.inner;
    }

    public void setInner(Exp inner) { this.inner = inner; }

    public Neg(Exp inner) {
        this.inner = inner;
    }
}
