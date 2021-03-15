package trivially.ep.i2;

public abstract interface Neg<V> extends trivially.ep.m7.Neg<V>, Exp<V> {

    public abstract Exp<V> getInner();

    public default Exp<V> simplify() {
        return this.convert(trivially.ep.m7.Neg.super.simplify());
    }

    public default Exp<V> multby(trivially.ep.Exp<V> other) {
        return this.convert(trivially.ep.m7.Neg.super.multby(other));
    }

    public default Exp<V> powby(trivially.ep.Exp<V> other) {
        return this.convert(trivially.ep.m7.Neg.super.powby(other));
    }
}
