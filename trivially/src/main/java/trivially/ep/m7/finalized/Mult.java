package trivially.ep.m7.finalized;

import trivially.ep.m7.Exp;

public class Mult implements trivially.ep.m7.Mult {

    protected Exp left;

    public Exp getLeft() {
        return this.left;
    }

    protected Exp right;

    public Exp getRight() {
        return this.right;
    }

    // Warning: Unsafe casts
    public void setLeft(trivially.ep.m4.Exp left) { this.left = (trivially.ep.m7.Exp) left; }
    public void setRight(trivially.ep.m4.Exp right) { this.right = (trivially.ep.m7.Exp) right; }

    public Mult(Exp left, Exp right) {
        this.left = left;
        this.right = right;
    }
}
