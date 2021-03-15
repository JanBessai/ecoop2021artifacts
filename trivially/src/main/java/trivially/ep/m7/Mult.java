package trivially.ep.m7;

public abstract interface Mult<V> extends trivially.ep.i1.Mult<V>, Exp<V> {

    public abstract Exp<V> getLeft();

    public abstract Exp<V> getRight();

    public default Exp<V> powby(trivially.ep.Exp<V> other) {
        return this.mult(this.getLeft().powby(this.convert(other)), this.getRight().powby(this.convert(other)));
    }

    public default Exp<V> simplify() {
        return this.convert(trivially.ep.i1.Mult.super.simplify());
    }

    public default Exp<V> multby(trivially.ep.Exp<V> other) {
        return this.convert(trivially.ep.i1.Mult.super.multby(other));
    }
}
