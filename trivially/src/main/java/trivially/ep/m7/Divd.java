package trivially.ep.m7;

public abstract interface Divd<V> extends trivially.ep.i1.Divd<V>, Exp<V> {

    public abstract Exp<V> getLeft();

    public abstract Exp<V> getRight();

    public default Exp<V> powby(trivially.ep.Exp<V> other) {
        return this.divd(this.getLeft().powby(this.convert(other)), this.getRight().powby(this.convert(other)));
    }

    public default Exp<V> simplify() {
        return this.convert(trivially.ep.i1.Divd.super.simplify());
    }

    public default Exp<V> multby(trivially.ep.Exp<V> other) {
        return this.convert(trivially.ep.i1.Divd.super.multby(other));
    }
}
