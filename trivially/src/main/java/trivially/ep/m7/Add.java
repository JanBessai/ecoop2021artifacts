package trivially.ep.m7;

public abstract interface Add<V> extends trivially.ep.i1.Add<V>, Exp<V> {

    public abstract Exp<V> getLeft();

    public abstract Exp<V> getRight();

    public default Exp<V> powby(trivially.ep.Exp<V> other) {
        return this.lit(this.eval()).powby(this.convert(other));
    }

    public default Exp<V> simplify() {
        return this.convert(trivially.ep.i1.Add.super.simplify());
    }

    public default Exp<V> multby(trivially.ep.Exp<V> other) {
        return this.convert(trivially.ep.i1.Add.super.multby(other));
    }
}
