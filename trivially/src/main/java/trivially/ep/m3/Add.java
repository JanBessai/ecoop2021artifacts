package trivially.ep.m3;

public abstract interface Add<V> extends trivially.ep.m2.Add<V>, Exp<V> {

    public abstract Exp<V> getLeft();

    public abstract Exp<V> getRight();
}
