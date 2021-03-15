package vita.ep.m1;

public abstract interface Sub<V> extends Exp<V> {

    public abstract Exp<V> getLeft();

    public abstract Exp<V> getRight();

    public default Double eval() {
        return this.getLeft().eval() - this.getRight().eval();
    }
}
