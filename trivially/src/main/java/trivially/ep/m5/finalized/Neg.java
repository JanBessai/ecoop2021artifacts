package trivially.ep.m5.finalized;

import trivially.ep.m5.Exp;

public class Neg implements trivially.ep.m5.Neg {

    protected Exp inner;

    public Exp getInner() {
        return this.inner;
    }

    // Warning: Unsafe casts
    public void setInner(trivially.ep.m4.Exp inner) { this.inner = (Exp) inner; }

    public Neg(Exp inner) {
        this.inner = inner;
    }
}
