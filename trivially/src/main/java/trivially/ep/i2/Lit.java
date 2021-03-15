package trivially.ep.i2;

public abstract interface Lit<V> extends trivially.ep.m7.Lit<V>, Exp<V> {

    public abstract Double getValue();

    public default Exp<V> simplify() {
        return this.convert(trivially.ep.m7.Lit.super.simplify());
    }

    public default Exp<V> multby(trivially.ep.Exp<V> other) {
        return this.convert(trivially.ep.m7.Lit.super.multby(other));
    }

    public default Exp<V> powby(trivially.ep.Exp<V> other) {
        return this.convert(trivially.ep.m7.Lit.super.powby(other));
    }
}
