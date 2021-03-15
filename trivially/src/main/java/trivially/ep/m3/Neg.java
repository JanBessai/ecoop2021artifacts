package trivially.ep.m3;

public abstract interface Neg<V> extends Exp<V> {

    public abstract Exp<V> getInner();

    public default String prettyp() {
        return "-" + this.getInner().prettyp();
    }

    public default Double eval() {
        return -1.0 * this.getInner().eval();
    }
}
