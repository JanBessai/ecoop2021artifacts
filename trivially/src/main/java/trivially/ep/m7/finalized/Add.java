package trivially.ep.m7.finalized;

import trivially.ep.m7.Exp;

public class Add implements trivially.ep.m7.Add<Visitor>, Factory {

    protected Exp<Visitor> left;

    protected Exp<Visitor> right;

    public Add(Exp<Visitor> _left, Exp<Visitor> _right) {
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
