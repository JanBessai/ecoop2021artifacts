package coco.ep.m5.finalized;

import coco.ep.m5.finalized.Exp;

public class Add extends Exp implements coco.ep.m5.Add<Exp> {

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
    
    public void setLeft(coco.ep.Exp<Exp> _left) {
        this.left = convert(_left);
    }

    public void setRight(coco.ep.Exp<Exp> _right) {
        this.right = convert(_right);
    }
}
