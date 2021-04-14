package trivially.ep.m6.finalized;

import trivially.ep.m6.Exp;

public class Neg implements trivially.ep.m6.Neg {

    protected Exp inner;

    public Exp getInner() {
        return this.inner;
    }

    // Warning: Unsafe casts
    public void setInner(trivially.ep.m4.Exp inner) { this.inner = (trivially.ep.m6.Exp) inner; }

    public Neg(Exp inner) {
        this.inner = inner;
    }
}
