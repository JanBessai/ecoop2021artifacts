package trivially.ep.m5;

import util.Node;
import util.Tree;

public interface Mult<V> extends trivially.ep.m4.Mult<V>, Exp<V> {

    Exp<V> getLeft();

    Exp<V> getRight();

    default Tree astree() {
        return new Node(this.id(), this.getLeft().astree(), this.getRight().astree());
    }

    default Integer id() {
        return 2409808;
    }

    default Exp<V> simplify() {
        return this.convert(trivially.ep.m4.Mult.super.simplify());
    }
}
