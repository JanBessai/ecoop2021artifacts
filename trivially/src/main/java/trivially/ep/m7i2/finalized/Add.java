package trivially.ep.m7i2.finalized;

import trivially.ep.m7i2.Exp;

public class Add implements trivially.ep.m7i2.Add {

    protected Exp left;

    public Exp getLeft() {
        return this.left;
    }

    protected Exp right;

    public Exp getRight() {
        return this.right;
    }

    // Warning: Unsafe casts
    public void setLeft(trivially.ep.m4.Exp left) { this.left = (trivially.ep.m7i2.Exp) left; }
    public void setRight(trivially.ep.m4.Exp right) { this.right = (trivially.ep.m7i2.Exp) right; }

    public Add(Exp left, Exp right) {
        this.left = left;
        this.right = right;
    }
}
