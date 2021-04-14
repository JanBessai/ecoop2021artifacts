package trivially.ep.i2.finalized;

import trivially.ep.i1.Exp;

public class Power implements trivially.ep.i2.Power {

    protected Exp left;

    public Exp getLeft() {
        return this.left;
    }

    protected Exp right;

    public Exp getRight() {
        return this.right;
    }

    public Power(Exp left, Exp right) {
        this.left = left;
        this.right = right;
    }
}
