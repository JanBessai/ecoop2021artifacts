package trivially.ep.m3.finalized;

import trivially.ep.m2.Exp;

public class Mult implements trivially.ep.m3.Mult {

    protected Exp left;

    public Exp getLeft() {
        return this.left;
    }

    protected Exp right;

    public Exp getRight() {
        return this.right;
    }

    public Mult(Exp left, Exp right) {
        this.left = left;
        this.right = right;
    }
}
