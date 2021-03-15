package trivially.ep.m7i2;

public abstract interface Lit<V> extends trivially.ep.i2.Lit<V>, Exp<V> {

    public abstract Double getValue();

    public default Exp<V> simplify() {
        return this.convert(trivially.ep.i2.Lit.super.simplify());
    }

    public default Exp<V> multby(trivially.ep.Exp<V> other) {
        return this.convert(trivially.ep.i2.Lit.super.multby(other));
    }

    public default Exp<V> powby(trivially.ep.Exp<V> other) {
        return this.convert(trivially.ep.i2.Lit.super.powby(other));
    }
}
