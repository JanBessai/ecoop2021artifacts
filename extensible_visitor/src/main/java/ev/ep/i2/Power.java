package ev.ep.i2;

import ev.ep.Exp;
import ev.ep.Visitor;

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

    public void setLeft(Exp _left) { this.left = _left; }
    public void setRight(Exp _right) { this.right = _right; }

    public <R> R accept(Visitor<R> v) {
        return ((VisitorPower<R>) v).visit(this);
    }
}
