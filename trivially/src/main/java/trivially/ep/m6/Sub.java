package trivially.ep.m6;

import trivially.ep.m6.finalized.Lit;

public interface Sub extends Exp, trivially.ep.m5.Sub {

    Exp getLeft();
    Exp getRight();

    default Boolean equals(Exp other) {
        return this.astree().equals(other.astree());
    }

    default Exp simplify() {
        if (this.getLeft().eval().equals(this.getRight().eval())) {
            return new Lit(0.0);
        } else {
            return new trivially.ep.m6.finalized.Sub(this.getLeft().simplify(), this.getRight().simplify());
        }
    }

    default Boolean isSub(Exp left, Exp right) {
        return left.eql(getLeft()) && right.eql(getRight());
    }

    default Boolean eql(Exp that) { return that.isSub(getLeft(), getRight()); }

    default void truncate (int level) {
        if (level > 1) {
            getLeft().truncate(level-1);
            getRight().truncate(level-1);
        } else {
            setLeft(new trivially.ep.m6.finalized.Lit(getLeft().eval()));
            setRight(new trivially.ep.m6.finalized.Lit(getRight().eval()));
        }
    }
}
