package trivially.ep.m4.finalized;

import trivially.ep.m4.Exp;

public class Add implements trivially.ep.m4.Add {

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

    public Add(Exp left, Exp right) {
        this.left = left;
        this.right = right;
    }
}
