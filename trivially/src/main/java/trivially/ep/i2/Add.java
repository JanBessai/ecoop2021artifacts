package trivially.ep.i2;

public abstract interface Add<V> extends trivially.ep.m7.Add<V>, Exp<V> {

    public abstract Exp<V> getLeft();

    public abstract Exp<V> getRight();

    public default Exp<V> simplify() {
        return this.convert(trivially.ep.m7.Add.super.simplify());
    }

    public default Exp<V> multby(trivially.ep.Exp<V> other) {
        return this.convert(trivially.ep.m7.Add.super.multby(other));
    }

    public default Exp<V> powby(trivially.ep.Exp<V> other) {
        return this.convert(trivially.ep.m7.Add.super.powby(other));
    }
}
