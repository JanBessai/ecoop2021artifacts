package trivially.ep.m5;

import util.Leaf;
import util.Node;
import util.Tree;

public interface Lit<V> extends trivially.ep.m4.Lit<V>, Exp<V> {

    Double getValue();

    default Tree astree() {
        return new Node(this.id(), new Leaf<Double>(this.getValue()));
    }

    default Integer id() {
        return 76407;
    }

    default Exp<V> simplify() {
        return convert(trivially.ep.m4.Lit.super.simplify());
    }
}
