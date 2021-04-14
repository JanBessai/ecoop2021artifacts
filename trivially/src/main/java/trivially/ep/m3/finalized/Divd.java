package trivially.ep.m3.finalized;

import trivially.ep.m2.Exp;

public class Divd implements trivially.ep.m3.Divd {

    protected Exp left;

    public Exp getLeft() {
        return this.left;
    }

    protected Exp right;

    public Exp getRight() {
        return this.right;
    }

    public Divd(Exp left, Exp right) {
        this.left = left;
        this.right = right;
    }
}
