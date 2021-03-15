package vita.ep.m6;

import java.util.List;
import org.combinators.vita.ep.util.Tree;

public abstract interface Neg<V> extends vita.ep.m5.Neg<V>, Exp<V> {

    public abstract Exp<V> getInner();

    public default String prettyp() {
        return vita.ep.m5.Neg.super.prettyp();
    }

    public default Exp<V> simplify() {
        return this.convert(vita.ep.m5.Neg.super.simplify());
    }

    public default List<Double> collect() {
        return vita.ep.m5.Neg.super.collect();
    }

    public default Tree astree() {
        return vita.ep.m5.Neg.super.astree();
    }

    public default Integer id() {
        return vita.ep.m5.Neg.super.id();
    }

    public default Boolean equals(vita.ep.Exp<V> other) {
        return this.astree().equals(this.convert(other).astree());
    }

    public default Double eval() {
        return vita.ep.m5.Neg.super.eval();
    }
}
