package trivially.ep.m7i2;

public abstract interface Neg<V> extends trivially.ep.i2.Neg<V>, Exp<V> {

    public abstract Exp<V> getInner();

    public default Exp<V> simplify() {
        return this.convert(trivially.ep.i2.Neg.super.simplify());
    }

    public default Exp<V> multby(trivially.ep.Exp<V> other) {
        return this.convert(trivially.ep.i2.Neg.super.multby(other));
    }

    public default Exp<V> powby(trivially.ep.Exp<V> other) {
        return this.convert(trivially.ep.i2.Neg.super.powby(other));
    }
}
