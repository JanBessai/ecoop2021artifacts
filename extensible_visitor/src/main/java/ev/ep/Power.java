package ev.ep;

public class Power extends Exp {

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

    public <R> R accept(Visitor<R> v) {
        return ((VisitorPower<R>) v).visit(this);
    }
}
