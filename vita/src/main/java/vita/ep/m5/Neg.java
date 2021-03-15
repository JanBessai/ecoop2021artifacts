package vita.ep.m5;

import java.util.List;
import org.combinators.vita.ep.util.Node;
import org.combinators.vita.ep.util.Tree;

public abstract interface Neg<V> extends vita.ep.m4.Neg<V>, Exp<V> {

    public abstract Exp<V> getInner();

    public default String prettyp() {
        return vita.ep.m4.Neg.super.prettyp();
    }

    public default Exp<V> simplify() {
        return this.convert(vita.ep.m4.Neg.super.simplify());
    }

    public default List<Double> collect() {
        return vita.ep.m4.Neg.super.collect();
    }

    public default Tree astree() {
        return new Node(this.id(), this.getInner().astree());
    }

    public default Integer id() {
        return 78192;
    }

    public default Double eval() {
        return vita.ep.m4.Neg.super.eval();
    }
}
