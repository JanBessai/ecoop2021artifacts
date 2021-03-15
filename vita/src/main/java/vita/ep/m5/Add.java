package vita.ep.m5;

import java.util.List;
import org.combinators.vita.ep.util.Node;
import org.combinators.vita.ep.util.Tree;

public abstract interface Add<V> extends vita.ep.m4.Add<V>, Exp<V> {

    public abstract Exp<V> getLeft();

    public abstract Exp<V> getRight();

    public default String prettyp() {
        return vita.ep.m4.Add.super.prettyp();
    }

    public default Exp<V> simplify() {
        return this.convert(vita.ep.m4.Add.super.simplify());
    }

    public default List<Double> collect() {
        return vita.ep.m4.Add.super.collect();
    }

    public default Tree astree() {
        return new Node(this.id(), this.getLeft().astree(), this.getRight().astree());
    }

    public default Integer id() {
        return 65665;
    }

    public default Double eval() {
        return vita.ep.m4.Add.super.eval();
    }
}
