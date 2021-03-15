package coco.ep.i1.finalized;

import coco.ep.i1.finalized.Exp;

public class Add extends Exp implements coco.ep.i1.Add<Exp> {

    protected Exp left;

    protected Exp right;

    public Add(Exp _left, Exp _right) {
        this.left = _left;
        this.right = _right;
    }

    public Exp getLeft() {
        return this.left;
    }

    public Exp getRight() {
        return this.right;
    }
}
