package trivially.ep.m0;

public abstract interface Add<V> extends Exp<V> {

    public abstract Exp<V> getLeft();

    public abstract Exp<V> getRight();

    public default Double eval() {
        return this.getLeft().eval() + this.getRight().eval();
    }
}
