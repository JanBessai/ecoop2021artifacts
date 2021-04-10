package ev.ep.m1;

import ev.ep.Exp;
import ev.ep.Visitor;

public class Sub extends Exp {

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

    public <R> R accept(Visitor<R> v) {
        return ((VisitorSub<R>) v).visit(this);
    }
}