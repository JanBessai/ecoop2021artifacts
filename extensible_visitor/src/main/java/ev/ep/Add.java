package ev.ep;

public class Add extends Exp {

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

    public <R> R accept(Visitor<R> v) {
        return ((Visitor<R>) v).visit(this);
    }
}
