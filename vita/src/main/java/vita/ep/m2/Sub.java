package vita.ep.m2;

public abstract interface Sub<V> extends vita.ep.m1.Sub<V>, Exp<V> {

    public abstract Exp<V> getLeft();

    public abstract Exp<V> getRight();

    public default String prettyp() {
        return "(" + this.getLeft().prettyp() + "-" + this.getRight().prettyp() + ")";
    }

    public default Double eval() {
        return vita.ep.m1.Sub.super.eval();
    }
}
