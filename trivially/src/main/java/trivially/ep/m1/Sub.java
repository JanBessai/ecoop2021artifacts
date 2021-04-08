package trivially.ep.m1;

public interface Sub<V> extends Exp<V> {

    Exp<V> getLeft();

    Exp<V> getRight();

    default Double eval() {
        return this.getLeft().eval() - this.getRight().eval();
    }
}
