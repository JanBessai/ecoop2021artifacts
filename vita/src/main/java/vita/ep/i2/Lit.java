package vita.ep.i2;

public abstract interface Lit<V> extends vita.ep.i1.Lit<V>, Exp<V> {

    public abstract Double getValue();

    public default String prettyp() {
        return vita.ep.i1.Lit.super.prettyp();
    }

    public default Exp<V> multby(vita.ep.Exp<V> other) {
        return this.convert(vita.ep.i1.Lit.super.multby(other));
    }

    public default Double eval() {
        return vita.ep.i1.Lit.super.eval();
    }
}
