package trivially.ep.m7i2;

import trivially.ep.m7i2.finalized.Lit;

public interface Neg extends Exp, trivially.ep.m7.Neg {

    Exp getInner();

    // unsafe casts
    default Exp powby(trivially.ep.m7.Exp other) { return new trivially.ep.m7i2.finalized.Power(this, (trivially.ep.m7i2.Exp)other); }
    default Exp multby(trivially.ep.i1.Exp other) { return  new trivially.ep.m7i2.finalized.Mult(this, (trivially.ep.m7i2.Exp)other); }

    default Exp simplify() {
        if (this.getInner().eval().equals(0.0)) {
            return new Lit(0.0);
        } else {
            return new trivially.ep.m7i2.finalized.Neg(this.getInner().simplify());
        }
    }

    default void truncate (int level) {
        if (level > 1) {
            getInner().truncate(level-1);
        } else {
            setInner(new trivially.ep.m7i2.finalized.Lit(getInner().eval()));
        }
    }
}
