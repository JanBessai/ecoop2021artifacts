package coco.ep.m2.finalized;

public class Sub extends Exp implements coco.ep.m2.Sub<Exp> {

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
