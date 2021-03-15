package trivially.ep.m3;

public abstract interface Sub<V> extends trivially.ep.m2.Sub<V>, Exp<V> {

    public abstract Exp<V> getLeft();

    public abstract Exp<V> getRight();
}
