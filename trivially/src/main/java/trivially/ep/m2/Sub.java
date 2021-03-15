package trivially.ep.m2;

public abstract interface Sub<V> extends trivially.ep.m1.Sub<V>, Exp<V> {

    public abstract Exp<V> getLeft();

    public abstract Exp<V> getRight();

    public default String prettyp() {
        return "(" + this.getLeft().prettyp() + "-" + this.getRight().prettyp() + ")";
    }
}
