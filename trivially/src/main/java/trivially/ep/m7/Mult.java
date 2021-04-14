package trivially.ep.m7;

import trivially.ep.m7.finalized.Lit;

public interface Mult extends Exp, trivially.ep.m6.Mult {

    Exp getLeft();

    Exp getRight();

    default Exp powby(Exp other) {
        return new trivially.ep.m7.finalized.Mult(this.getLeft().powby(((Exp) other)), this.getRight().powby(((Exp) other)));
    }

    default Exp simplify() {
        if (Double.valueOf(this.getLeft().eval()).equals(0.0) || Double.valueOf(this.getRight().eval()).equals(0.0)) {
            return new Lit(0.0);
        } else if (Double.valueOf(this.getLeft().eval()).equals(1.0)) {
            return this.getRight().simplify();
        } else if (Double.valueOf(this.getRight().eval()).equals(1.0)) {
            return this.getLeft().simplify();
        } else {
            return new trivially.ep.m7.finalized.Mult(this.getLeft().simplify(), this.getRight().simplify());
        }
    }

    default void truncate (int level) {
        if (level > 1) {
            getLeft().truncate(level-1);
            getRight().truncate(level-1);
        } else {
            setLeft(new trivially.ep.m7.finalized.Lit(getLeft().eval()));
            setRight(new trivially.ep.m7.finalized.Lit(getRight().eval()));
        }
    }
}
