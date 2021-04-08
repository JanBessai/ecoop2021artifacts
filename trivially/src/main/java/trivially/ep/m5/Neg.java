package trivially.ep.m5;

import util.Node;
import util.Tree;

public interface Neg<V> extends trivially.ep.m4.Neg<V>, Exp<V> {

    Exp<V> getInner();

    default Tree astree() {
        return new Node(this.id(), this.getInner().astree());
    }

    default Integer id() {
        return 78192;
    }

    default Exp<V> simplify() {
        return convert(trivially.ep.m4.Neg.super.simplify());
    }
}
