package trivially.ep.i1;

public abstract interface Neg<V> extends trivially.ep.m6.Neg<V>, Exp<V> {

    public abstract Exp<V> getInner();

    public default Exp<V> multby(trivially.ep.Exp<V> other) {
        return this.mult(this, this.convert(other));
    }

    public default Exp<V> simplify() {
        return this.convert(trivially.ep.m6.Neg.super.simplify());
    }
}
