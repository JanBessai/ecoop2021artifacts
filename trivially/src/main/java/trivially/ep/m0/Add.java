package trivially.ep.m0;

public interface Add<V> extends Exp<V> {

    Exp<V> getLeft();
    Exp<V> getRight();

    default Double eval() {
        return this.getLeft().eval() + this.getRight().eval();
    }
}
