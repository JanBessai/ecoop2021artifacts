package coco.ep.m1.finalized;

import coco.ep.m0.finalized.Exp;

public class Sub extends Exp implements Factory, coco.ep.m1.Sub<Exp> {

    protected Exp left;

    protected Exp right;

    public Sub(Exp _left, Exp _right) {
        this.left = _left;
        this.right = _right;
    }

    public Exp getLeft() {
        return left;
    }

    public Exp getRight() {
        return right;
    }
}
