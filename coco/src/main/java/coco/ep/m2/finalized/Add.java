package coco.ep.m2.finalized;

import coco.ep.m2.finalized.Exp;

public class Add extends Exp implements coco.ep.m2.Add<Exp> {

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
