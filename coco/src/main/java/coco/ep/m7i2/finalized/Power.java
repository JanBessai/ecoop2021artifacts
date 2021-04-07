package coco.ep.m7i2.finalized;

public class Power extends Exp implements coco.ep.m7i2.Power<Exp> {

    protected Exp left;
    protected Exp right;

    public Power(Exp _left, Exp _right) {
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
