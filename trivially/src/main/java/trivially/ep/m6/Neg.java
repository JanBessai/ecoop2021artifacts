package trivially.ep.m6;

public abstract interface Neg<V> extends trivially.ep.m5.Neg<V>, Exp<V> {

    public abstract Exp<V> getInner();

    public default Boolean equals(trivially.ep.Exp<V> other) {
        return this.astree().equals(this.convert(other).astree());
    }

    public default Exp<V> simplify() {
        return this.convert(trivially.ep.m5.Neg.super.simplify());
    }
}
