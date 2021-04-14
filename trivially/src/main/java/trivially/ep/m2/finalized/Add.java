package trivially.ep.m2.finalized;

import trivially.ep.m2.Exp;

public class Add implements trivially.ep.m2.Add {

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
