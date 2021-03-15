package coco.ep.m7i2.finalized;

import coco.ep.m7i2.finalized.Exp;

public class Sub extends Exp implements coco.ep.m7i2.Sub<Exp> {

    protected Exp left;

    protected Exp right;

    public Sub(Exp _left, Exp _right) {
        this.left = _left;
        this.right = _right;
    }

    public Exp getLeft() {
        return this.left;
    }

    public Exp getRight() {
        return this.right;
    }   
    
    public void setLeft(coco.ep.Exp<Exp> _left) {
        this.left = convert(_left);
    }

    public void setRight(coco.ep.Exp<Exp> _right) {
        this.right = convert(_right);
    }
}
