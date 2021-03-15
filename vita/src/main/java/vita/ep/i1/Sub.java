package vita.ep.i1;

public abstract interface Sub<V> extends vita.ep.m2.Sub<V>, Exp<V> {

    public abstract Exp<V> getLeft();

    public abstract Exp<V> getRight();

    public default String prettyp() {
        return vita.ep.m2.Sub.super.prettyp();
    }

    public default Exp<V> multby(vita.ep.Exp<V> other) {
        return this.sub(this.getLeft().multby(this.convert(other)), this.getRight().multby(this.convert(other)));
    }

    public default Double eval() {
        return vita.ep.m2.Sub.super.eval();
    }
}
