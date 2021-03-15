package trivially.ep.m2;

public abstract interface Add<V> extends trivially.ep.m1.Add<V>, Exp<V> {

    public abstract Exp<V> getLeft();

    public abstract Exp<V> getRight();

    public default String prettyp() {
        return "(" + this.getLeft().prettyp() + "+" + this.getRight().prettyp() + ")";
    }
}
