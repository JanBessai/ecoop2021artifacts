package trivially.ep.m7i2;

import trivially.ep.m7i2.finalized.Lit;

public interface Add extends Exp, trivially.ep.m7.Add, trivially.ep.i1.Add {

    Exp getLeft();
    Exp getRight();

    // unsafe casts
    default Exp powby(trivially.ep.m7.Exp other) { return new trivially.ep.m7i2.finalized.Power(this, (trivially.ep.m7i2.Exp)other); }
    default Exp multby(trivially.ep.i1.Exp other) { return  new trivially.ep.m7i2.finalized.Mult(this, (trivially.ep.m7i2.Exp)other); }

    default Exp simplify() {
        if (Double.valueOf(this.getLeft().eval() + this.getRight().eval()).equals(0.0)) {
            return new Lit(0.0);
        } else if (this.getLeft().eval().equals(0.0)) {
            return this.getRight().simplify();
        } else if (this.getRight().eval().equals(0.0)) {
            return this.getLeft().simplify();
        } else {
            return new trivially.ep.m7i2.finalized.Add(this.getLeft().simplify(), this.getRight().simplify());
        }
    }

    default void truncate (int level) {
        if (level > 1) {
            getLeft().truncate(level-1);
            getRight().truncate(level-1);
        } else {
            setLeft(new trivially.ep.m7i2.finalized.Lit(getLeft().eval()));
            setRight(new trivially.ep.m7i2.finalized.Lit(getRight().eval()));
        }
    }
}
