package coco.ep.i2.finalized;

import coco.ep.i1.finalized.Exp;

public class Power extends Exp implements Factory, coco.ep.i2.Power<Exp> {

    protected Exp left;
    protected Exp right;

    public Power(Exp _left, Exp _right) {
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
