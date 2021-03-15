package vita.ep.i2;

public abstract interface Add<V> extends vita.ep.i1.Add<V>, Exp<V> {

    public abstract Exp<V> getLeft();

    public abstract Exp<V> getRight();

    public default String prettyp() {
        return vita.ep.i1.Add.super.prettyp();
    }

    public default Exp<V> multby(vita.ep.Exp<V> other) {
        return this.convert(vita.ep.i1.Add.super.multby(other));
    }

    public default Double eval() {
        return vita.ep.i1.Add.super.eval();
    }
}
