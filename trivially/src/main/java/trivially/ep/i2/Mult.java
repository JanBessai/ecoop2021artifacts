package trivially.ep.i2;

public abstract interface Mult<V> extends trivially.ep.m7.Mult<V>, Exp<V> {

    public abstract Exp<V> getLeft();

    public abstract Exp<V> getRight();

    public default Exp<V> simplify() {
        return this.convert(trivially.ep.m7.Mult.super.simplify());
    }

    public default Exp<V> multby(trivially.ep.Exp<V> other) {
        return this.convert(trivially.ep.m7.Mult.super.multby(other));
    }

    public default Exp<V> powby(trivially.ep.Exp<V> other) {
        return this.convert(trivially.ep.m7.Mult.super.powby(other));
    }
}
