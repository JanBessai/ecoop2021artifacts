package trivially.ep.m7i2;

public abstract interface Sub<V> extends trivially.ep.i2.Sub<V>, Exp<V> {

    public abstract Exp<V> getLeft();

    public abstract Exp<V> getRight();

    public default Exp<V> simplify() {
        return this.convert(trivially.ep.i2.Sub.super.simplify());
    }

    public default Exp<V> multby(trivially.ep.Exp<V> other) {
        return this.convert(trivially.ep.i2.Sub.super.multby(other));
    }

    public default Exp<V> powby(trivially.ep.Exp<V> other) {
        return this.convert(trivially.ep.i2.Sub.super.powby(other));
    }
}
