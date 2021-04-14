package trivially.ep.m7i2.finalized;

import trivially.ep.m7i2.Exp;

public class Power implements trivially.ep.m7i2.Power {

    protected Exp left;

    public Exp getLeft() {
        return this.left;
    }

    protected Exp right;

    public Exp getRight() {
        return this.right;
    }

    public void setLeft(Exp left) { this.left = left; }
    public void setRight(Exp right) { this.right = right; }

    public Power(Exp left, Exp right) {
        this.left = left;
        this.right = right;
    }
}
