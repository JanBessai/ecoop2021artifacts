package trivially.ep.i1.finalized;

import trivially.ep.i1.Exp;

public class Sub implements trivially.ep.i1.Sub {

    protected Exp left;

    public Exp getLeft() {
        return this.left;
    }

    protected Exp right;

    public Exp getRight() {
        return this.right;
    }

    public Sub(Exp left, Exp right) {
        this.left = left;
        this.right = right;
    }
}
