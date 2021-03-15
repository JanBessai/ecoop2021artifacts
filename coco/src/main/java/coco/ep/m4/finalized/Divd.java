package coco.ep.m4.finalized;

import coco.ep.m4.finalized.Exp;

public class Divd extends Exp implements coco.ep.m4.Divd<Exp> {

    protected Exp left;

    protected Exp right;

    public Divd(Exp _left, Exp _right) {
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
