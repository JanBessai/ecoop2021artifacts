package coco.ep.m3.finalized;

import coco.ep.m2.finalized.Exp;

public class Mult extends Exp implements Factory, coco.ep.m3.Mult<Exp> {

    protected Exp left;
    protected Exp right;

    public Mult(Exp _left, Exp _right) {
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
