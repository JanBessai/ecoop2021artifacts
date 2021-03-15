package trivially.ep.m7;

public abstract interface Neg<V> extends trivially.ep.i1.Neg<V>, Exp<V> {

    public abstract Exp<V> getInner();

    public default Exp<V> powby(trivially.ep.Exp<V> other) {
        return this.mult(this.lit(1.0).powby(this.getInner()), this.getInner().powby(this.convert(other)));
    }

    public default Exp<V> simplify() {
        return this.convert(trivially.ep.i1.Neg.super.simplify());
    }

    public default Exp<V> multby(trivially.ep.Exp<V> other) {
        return this.convert(trivially.ep.i1.Neg.super.multby(other));
    }
}
