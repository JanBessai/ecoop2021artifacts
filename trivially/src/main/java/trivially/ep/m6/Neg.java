package trivially.ep.m6;

import trivially.ep.m6.finalized.Lit;

public interface Neg extends Exp, trivially.ep.m5.Neg {

    Exp getInner();

    default Boolean equals(Exp other) {
        return this.astree().equals(other.astree());
    }

    default Exp simplify() {
        if (this.getInner().eval().equals(0.0)) {
            return new Lit(0.0);
        } else {
            return new trivially.ep.m6.finalized.Neg(this.getInner().simplify());
        }
    }

    default Boolean isNeg(Exp inner) {
        return inner.eql(getInner());
    }

    default Boolean eql(Exp that) { return that.isNeg(getInner()); }

    default void truncate (int level) {
        if (level > 1) {
            getInner().truncate(level-1);
        } else {
            setInner(new trivially.ep.m5.finalized.Lit(getInner().eval()));
        }
    }
}
