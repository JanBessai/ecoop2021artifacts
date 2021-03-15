package vita.ep.m5;

import java.util.List;
import org.combinators.vita.ep.util.Leaf;
import org.combinators.vita.ep.util.Node;
import org.combinators.vita.ep.util.Tree;

public abstract interface Lit<V> extends vita.ep.m4.Lit<V>, Exp<V> {

    public abstract Double getValue();

    public default String prettyp() {
        return vita.ep.m4.Lit.super.prettyp();
    }

    public default Exp<V> simplify() {
        return this.convert(vita.ep.m4.Lit.super.simplify());
    }

    public default List<Double> collect() {
        return vita.ep.m4.Lit.super.collect();
    }

    public default Tree astree() {
        return new Node(this.id(), new Leaf<Double>(this.getValue()));
    }

    public default Integer id() {
        return 76407;
    }

    public default Double eval() {
        return vita.ep.m4.Lit.super.eval();
    }
}
