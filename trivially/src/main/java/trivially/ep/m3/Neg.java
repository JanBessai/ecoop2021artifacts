package trivially.ep.m3;

public interface Neg<V> extends Exp<V> {

    Exp<V> getInner();

    default String prettyp() {
        return "(-" + this.getInner().prettyp() + ")";
    }

    default Double eval() {
        return -1.0 * this.getInner().eval();
    }
}
