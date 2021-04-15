package coco.ep.m0.finalized;

public class Add extends Exp implements coco.ep.m0.Add<Exp> {

    protected Exp left;
    protected Exp right;

    public Add(Exp _left, Exp _right) {
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
