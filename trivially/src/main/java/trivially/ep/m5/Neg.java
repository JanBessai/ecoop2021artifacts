package trivially.ep.m5;

import util.Node;
import util.Tree;

public abstract interface Neg<V> extends trivially.ep.m4.Neg<V>, Exp<V> {

    public abstract Exp<V> getInner();

    public default Tree astree() {
        return new Node(this.id(), this.getInner().astree());
    }

    public default Integer id() {
        return 78192;
    }

    public default Exp<V> simplify() {
        return this.convert(trivially.ep.m4.Neg.super.simplify());
    }
}
