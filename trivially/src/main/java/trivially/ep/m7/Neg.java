package trivially.ep.m7;

import trivially.ep.m7.finalized.Lit;
import trivially.ep.m7.finalized.Mult;

public interface Neg extends Exp, trivially.ep.m6.Neg {

    Exp getInner();

    default Exp powby(Exp other) {
        return new Mult(new Lit(1.0).powby(this.getInner()), this.getInner().powby(other));
    }

    default Exp simplify() {
        if (this.getInner().eval().equals(0.0)) {
            return new Lit(0.0);
        } else {
            return new trivially.ep.m7.finalized.Neg(this.getInner().simplify());
        }
    }

    default void truncate (int level) {
        if (level > 1) {
            getInner().truncate(level-1);
        } else {
            setInner(new trivially.ep.m7.finalized.Lit(getInner().eval()));
        }
    }
}
