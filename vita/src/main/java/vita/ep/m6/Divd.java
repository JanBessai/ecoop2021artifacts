package vita.ep.m6;

import java.util.List;
import org.combinators.vita.ep.util.Tree;

public abstract interface Divd<V> extends vita.ep.m5.Divd<V>, Exp<V> {

    public abstract Exp<V> getLeft();

    public abstract Exp<V> getRight();

    public default String prettyp() {
        return vita.ep.m5.Divd.super.prettyp();
    }

    public default Exp<V> simplify() {
        return this.convert(vita.ep.m5.Divd.super.simplify());
    }

    public default List<Double> collect() {
        return vita.ep.m5.Divd.super.collect();
    }

    public default Tree astree() {
        return vita.ep.m5.Divd.super.astree();
    }

    public default Integer id() {
        return vita.ep.m5.Divd.super.id();
    }

    public default Boolean equals(vita.ep.Exp<V> other) {
        return this.astree().equals(this.convert(other).astree());
    }

    public default Double eval() {
        return vita.ep.m5.Divd.super.eval();
    }
}
