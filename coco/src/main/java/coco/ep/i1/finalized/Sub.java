package coco.ep.i1.finalized;

public class Sub extends Exp implements coco.ep.i1.Sub<Exp> {

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
}
