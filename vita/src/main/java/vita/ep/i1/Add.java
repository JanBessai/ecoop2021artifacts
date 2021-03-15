package vita.ep.i1;

public abstract interface Add<V> extends vita.ep.m2.Add<V>, Exp<V> {

    public abstract Exp<V> getLeft();

    public abstract Exp<V> getRight();

    public default String prettyp() {
        return vita.ep.m2.Add.super.prettyp();
    }

    public default Exp<V> multby(vita.ep.Exp<V> other) {
        return this.add(this.getLeft().multby(this.convert(other)), this.getRight().multby(this.convert(other)));
    }

    public default Double eval() {
        return vita.ep.m2.Add.super.eval();
    }
}
