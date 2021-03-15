package trivially.ep.m3;

public abstract interface Mult<V> extends Exp<V> {

    public abstract Exp<V> getLeft();

    public abstract Exp<V> getRight();

    public default String prettyp() {
        return "(" + this.getLeft().prettyp() + "*" + this.getRight().prettyp() + ")";
    }

    public default Double eval() {
        return this.getLeft().eval() * this.getRight().eval();
    }
}
