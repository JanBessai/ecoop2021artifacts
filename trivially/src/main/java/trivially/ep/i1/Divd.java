package trivially.ep.i1;

public abstract interface Divd<V> extends trivially.ep.m6.Divd<V>, Exp<V> {

    public abstract Exp<V> getLeft();

    public abstract Exp<V> getRight();

    public default Exp<V> multby(trivially.ep.Exp<V> other) {
        return this.mult(this, this.convert(other));
    }

    public default Exp<V> simplify() {
        return this.convert(trivially.ep.m6.Divd.super.simplify());
    }
}
