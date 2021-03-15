package vita.ep.m1;

public abstract interface Add<V> extends vita.ep.m0.Add<V>, Exp<V> {

    public abstract Exp<V> getLeft();

    public abstract Exp<V> getRight();

    public default Double eval() {
        return vita.ep.m0.Add.super.eval();
    }
}
