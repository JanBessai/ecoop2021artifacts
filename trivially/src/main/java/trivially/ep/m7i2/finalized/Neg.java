package trivially.ep.m7i2.finalized;

import trivially.ep.m7i2.Exp;

public class Neg implements trivially.ep.m7i2.Neg {

    protected Exp inner;

    public Neg(Exp inner) {
        this.inner = inner;
    }

    public Exp getInner() {
        return this.inner;
    }

    // Warning: Unsafe casts
    public void setInner(trivially.ep.m4.Exp inner) { this.inner = (trivially.ep.m7i2.Exp) inner; }

}
