package trivially.ep.m3;

public interface Divd<V> extends Exp<V> {

    Exp<V> getLeft();
    Exp<V> getRight();

    default String prettyp() {
        return "(" + this.getLeft().prettyp() + "/" + this.getRight().prettyp() + ")";
    }

    default Double eval() {
        return this.getLeft().eval() / this.getRight().eval();
    }
}
