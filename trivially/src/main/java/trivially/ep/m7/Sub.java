package trivially.ep.m7;

import trivially.ep.m7.finalized.Lit;

public interface Sub extends Exp, trivially.ep.m6.Sub {

    Exp getLeft();

    Exp getRight();

    default Exp powby(Exp other) {
        return new Lit(this.eval()).powby(((Exp) other));
    }

    default Exp simplify() {
        if (Double.valueOf(this.getLeft().eval()).equals(this.getRight().eval())) {
            return new Lit(0.0);
        } else {
            return new trivially.ep.m7.finalized.Sub(this.getLeft().simplify(), this.getRight().simplify());
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
