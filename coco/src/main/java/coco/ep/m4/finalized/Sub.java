package coco.ep.m4.finalized;

public class Sub extends Exp implements coco.ep.m4.Sub<Exp> {

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
    
    public void setLeft(coco.ep.Exp<Exp> _left) {
        left = convert(_left);
    }

    public void setRight(coco.ep.Exp<Exp> _right) {
        right = convert(_right);
    }
}
