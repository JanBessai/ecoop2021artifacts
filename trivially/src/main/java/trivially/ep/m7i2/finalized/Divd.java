package trivially.ep.m7i2.finalized;

import trivially.ep.m7i2.Exp;

public class Divd implements trivially.ep.m7i2.Divd<Visitor>, Factory {

    protected Exp<Visitor> left;

    protected Exp<Visitor> right;

    public Divd(Exp<Visitor> _left, Exp<Visitor> _right) {
        this.left = _left;
        this.right = _right;
    }

    public Exp<Visitor> getLeft() {
        return this.left;
    }

    public Exp<Visitor> getRight() {
        return this.right;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public Exp<Visitor> convert(trivially.ep.Exp<Visitor> other) {
        Visitor visitor = new Visitor();
        other.accept(visitor);
        return visitor.getResult();
    }
}
