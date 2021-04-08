package trivially.ep.m5;

import util.Node;
import util.Tree;

public interface Add<V> extends trivially.ep.m4.Add<V>, Exp<V> {

    Exp<V> getLeft();
    Exp<V> getRight();

    default Tree astree() {
        return new Node(this.id(), this.getLeft().astree(), this.getRight().astree());
    }

    default Integer id() {
        return 65665;
    }

    default Exp<V> simplify() {
        return convert(trivially.ep.m4.Add.super.simplify());
    }
}
