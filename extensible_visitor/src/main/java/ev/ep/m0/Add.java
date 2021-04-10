package ev.ep.m0;

import ev.ep.Exp;
import ev.ep.Visitor;

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
        return v.visit(this);
    }
}
