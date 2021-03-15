package vita.ep.m3;

public abstract interface Add<V> extends vita.ep.m2.Add<V>, Exp<V> {

    public abstract Exp<V> getLeft();

    public abstract Exp<V> getRight();

    public default String prettyp() {
        return vita.ep.m2.Add.super.prettyp();
    }

    public default Double eval() {
        return vita.ep.m2.Add.super.eval();
    }
}
