package vita.ep.m7i2;

import java.util.List;
import org.combinators.vita.ep.util.Tree;

public abstract interface Sub<V> extends vita.ep.m7.Sub<V>, vita.ep.i2.Sub<V>, Exp<V> {

    public abstract Exp<V> getLeft();

    public abstract Exp<V> getRight();

    public default String prettyp() {
        return vita.ep.m7.Sub.super.prettyp();
    }

    public default Exp<V> multby(vita.ep.Exp<V> other) {
        return this.convert(vita.ep.i2.Sub.super.multby(other));
    }

    public default Double eval() {
        return vita.ep.m7.Sub.super.eval();
    }

    public default Exp<V> simplify() {
        return this.convert(vita.ep.m7.Sub.super.simplify());
    }

    public default List<Double> collect() {
        return vita.ep.m7.Sub.super.collect();
    }

    public default Tree astree() {
        return vita.ep.m7.Sub.super.astree();
    }

    public default Integer id() {
        return vita.ep.m7.Sub.super.id();
    }

    public default Boolean equals(vita.ep.Exp<V> other) {
        return vita.ep.m7.Sub.super.equals(other);
    }

    public default Exp<V> powby(vita.ep.Exp<V> other) {
        return this.lit(this.eval()).powby(this.convert(other));
    }
}
