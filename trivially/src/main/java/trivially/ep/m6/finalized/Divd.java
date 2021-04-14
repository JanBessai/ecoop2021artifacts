package trivially.ep.m6.finalized;

import trivially.ep.m6.Exp;

public class Divd implements trivially.ep.m6.Divd {

    protected Exp left;

    public Exp getLeft() {
        return this.left;
    }

    protected Exp right;

    public Exp getRight() {
        return this.right;
    }

    // Warning: Unsafe casts
    public void setLeft(trivially.ep.m4.Exp left) { this.left = (trivially.ep.m6.Exp) left; }
    public void setRight(trivially.ep.m4.Exp right) { this.right = (trivially.ep.m6.Exp) right; }

    public Divd(Exp left, Exp right) {
        this.left = left;
        this.right = right;
    }
}
