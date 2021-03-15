package trivially.ep.m1;

public abstract interface Add<V> extends trivially.ep.m0.Add<V>, Exp<V> {

    public abstract Exp<V> getLeft();

    public abstract Exp<V> getRight();
}
