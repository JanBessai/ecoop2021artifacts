package vita.ep.m3.finalized;

import vita.ep.m3.Exp;

public class Add extends Factory implements vita.ep.m3.Add<Visitor> {

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

    public Exp<Visitor> convert(vita.ep.Exp<Visitor> other) {
        Visitor visitor = new Visitor();
        other.accept(visitor);
        return visitor.getResult();
    }
}
