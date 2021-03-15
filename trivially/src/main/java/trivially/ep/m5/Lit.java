package trivially.ep.m5;

import util.Leaf;
import util.Node;
import util.Tree;

public abstract interface Lit<V> extends trivially.ep.m4.Lit<V>, Exp<V> {

    public abstract Double getValue();

    public default Tree astree() {
        return new Node(this.id(), new Leaf<Double>(this.getValue()));
    }

    public default Integer id() {
        return 76407;
    }

    public default Exp<V> simplify() {
        return this.convert(trivially.ep.m4.Lit.super.simplify());
    }
}
