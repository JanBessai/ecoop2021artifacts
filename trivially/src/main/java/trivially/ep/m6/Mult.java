package trivially.ep.m6;

public interface Mult extends Exp, trivially.ep.m5.Mult {

    Exp getLeft();

    Exp getRight();

    default Boolean equals(Exp other) {
        return this.astree().equals(other.astree());
    }

    default Exp simplify() {
        if (this.getLeft().eval().equals(0.0) || this.getRight().eval().equals(0.0)) {
            return new trivially.ep.m6.finalized.Lit(0.0);
        } else if (this.getLeft().eval().equals(1.0)) {
            return this.getRight().simplify();
        } else if (this.getRight().eval().equals(1.0)) {
            return this.getLeft().simplify();
        } else {
            return new trivially.ep.m6.finalized.Mult(this.getLeft().simplify(), this.getRight().simplify());
        }
    }

    default Boolean isMult(Exp left, Exp right) {
        return left.eql(getLeft()) && right.eql(getRight());
    }

    default Boolean eql(Exp that) { return that.isMult(getLeft(), getRight()); }

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
