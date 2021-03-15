package trivially.ep.m5;

import util.Node;
import util.Tree;

public abstract interface Sub<V> extends trivially.ep.m4.Sub<V>, Exp<V> {

    public abstract Exp<V> getLeft();

    public abstract Exp<V> getRight();

    public default Tree astree() {
        return new Node(this.id(), this.getLeft().astree(), this.getRight().astree());
    }

    public default Integer id() {
        return 83488;
    }

    public default Exp<V> simplify() {
        return this.convert(trivially.ep.m4.Sub.super.simplify());
    }
}
