package trivially.ep.i1;

public abstract interface Sub<V> extends trivially.ep.m6.Sub<V>, Exp<V> {

    public abstract Exp<V> getLeft();

    public abstract Exp<V> getRight();

    public default Exp<V> multby(trivially.ep.Exp<V> other) {
        return this.sub(this.getLeft().multby(this.convert(other)), this.getRight().multby(this.convert(other)));
    }

    public default Exp<V> simplify() {
        return this.convert(trivially.ep.m6.Sub.super.simplify());
    }
}
