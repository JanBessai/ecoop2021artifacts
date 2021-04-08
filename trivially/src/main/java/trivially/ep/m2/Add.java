package trivially.ep.m2;

public interface Add<V> extends trivially.ep.m1.Add<V>, Exp<V> {

    Exp<V> getLeft();
    Exp<V> getRight();

    default String prettyp() {
        return "(" + this.getLeft().prettyp() + "+" + this.getRight().prettyp() + ")";
    }
}
