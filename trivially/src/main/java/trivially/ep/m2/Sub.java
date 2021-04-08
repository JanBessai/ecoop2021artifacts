package trivially.ep.m2;

public interface Sub<V> extends trivially.ep.m1.Sub<V>, Exp<V> {

    Exp<V> getLeft();

    Exp<V> getRight();

    default String prettyp() {
        return "(" + this.getLeft().prettyp() + "-" + this.getRight().prettyp() + ")";
    }
}
