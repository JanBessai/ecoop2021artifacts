package trivially.ep.m0.finalized;

import trivially.ep.m0.Exp;

public class Add implements trivially.ep.m0.Add {

    protected Exp left;

    public Exp getLeft() {
        return this.left;
    }

    protected Exp right;

    public Exp getRight() {
        return this.right;
    }

    public Add(Exp left, Exp right) {
        this.left = left;
        this.right = right;
    }
}
