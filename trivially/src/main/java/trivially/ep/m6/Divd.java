package trivially.ep.m6;

import trivially.ep.m6.finalized.Lit;

public interface Divd extends Exp, trivially.ep.m5.Divd {

    Exp getLeft();
    Exp getRight();

    default Boolean equals(Exp other) {
        return this.astree().equals(((Exp) other).astree());
    }

    default Exp simplify() {
        if (this.getLeft().eval().equals(0.0)) {
            return new Lit(0.0);
        } else if (this.getRight().eval().equals(1.0)) {
            return this.getLeft().simplify();
        } else if (this.getLeft().eval().equals(this.getRight().eval())) {
            return new Lit(1.0);
        } else if (this.getLeft().eval().equals(-1.0 * this.getRight().eval())) {
            return new Lit(-1.0);
        } else {
            return new trivially.ep.m6.finalized.Divd(this.getLeft().simplify(), this.getRight().simplify());
        }
    }

    default Boolean isDivd(Exp left, Exp right) {
        return left.eql(getLeft()) && right.eql(getRight());
    }

    default Boolean eql(Exp that) { return that.isDivd(getLeft(), getRight()); }

    default void truncate (int level) {
        if (level > 1) {
            getLeft().truncate(level-1);
            getRight().truncate(level-1);
        } else {
            setLeft(new trivially.ep.m5.finalized.Lit(getLeft().eval()));
            setRight(new trivially.ep.m5.finalized.Lit(getRight().eval()));
        }
    }
}
