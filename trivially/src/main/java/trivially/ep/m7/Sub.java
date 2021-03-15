package trivially.ep.m7;

public abstract interface Sub<V> extends trivially.ep.i1.Sub<V>, Exp<V> {

    public abstract Exp<V> getLeft();

    public abstract Exp<V> getRight();

    public default Exp<V> powby(trivially.ep.Exp<V> other) {
        return this.lit(this.eval()).powby(this.convert(other));
    }

    public default Exp<V> simplify() {
        return this.convert(trivially.ep.i1.Sub.super.simplify());
    }

    public default Exp<V> multby(trivially.ep.Exp<V> other) {
        return this.convert(trivially.ep.i1.Sub.super.multby(other));
    }
}
