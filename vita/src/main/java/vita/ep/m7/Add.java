package vita.ep.m7;

import java.util.List;
import org.combinators.vita.ep.util.Tree;

public abstract interface Add<V> extends vita.ep.m6.Add<V>, Exp<V> {

    public abstract Exp<V> getLeft();

    public abstract Exp<V> getRight();

    public default String prettyp() {
        return vita.ep.m6.Add.super.prettyp();
    }

    public default Exp<V> simplify() {
        return this.convert(vita.ep.m6.Add.super.simplify());
    }

    public default List<Double> collect() {
        return vita.ep.m6.Add.super.collect();
    }

    public default Tree astree() {
        return vita.ep.m6.Add.super.astree();
    }

    public default Integer id() {
        return vita.ep.m6.Add.super.id();
    }

    public default Boolean equals(vita.ep.Exp<V> other) {
        return vita.ep.m6.Add.super.equals(other);
    }

    public default Exp<V> powby(vita.ep.Exp<V> other) {
        return this.lit(this.eval()).powby(this.convert(other));
    }

    public default Double eval() {
        return vita.ep.m6.Add.super.eval();
    }
}
