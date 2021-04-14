package trivially.ep.m4.finalized;

import trivially.ep.m4.Exp;

public class Divd implements trivially.ep.m4.Divd {

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

    public Divd(Exp left, Exp right) {
        this.left = left;
        this.right = right;
    }
}
