package trivially.ep.m5.finalized;

import trivially.ep.m5.Exp;

public class Divd implements trivially.ep.m5.Divd {

    protected Exp left;

    public Exp getLeft() {
        return this.left;
    }

    protected Exp right;

    public Exp getRight() {
        return this.right;
    }

    // Warning: Unsafe casts
    public void setLeft(trivially.ep.m4.Exp left) { this.left = (Exp) left; }
    public void setRight(trivially.ep.m4.Exp right) { this.right = (Exp) right; }

    public Divd(Exp left, Exp right) {
        this.left = left;
        this.right = right;
    }
}
