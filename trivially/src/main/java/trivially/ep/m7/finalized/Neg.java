package trivially.ep.m7.finalized;

import trivially.ep.m7.Exp;

public class Neg implements trivially.ep.m7.Neg {

    protected Exp inner;

    public Exp getInner() {
        return this.inner;
    }

    // Warning: Unsafe casts
    public void setInner(trivially.ep.m4.Exp inner) { this.inner = (trivially.ep.m7.Exp) inner; }

    public Neg(Exp inner) {
        this.inner = inner;
    }
}
