package vita.ep.m7i2;

import java.util.List;
import org.combinators.vita.ep.util.Tree;

public abstract interface Divd<V> extends vita.ep.m7.Divd<V>, Exp<V> {

    public abstract Exp<V> getLeft();

    public abstract Exp<V> getRight();

    public default String prettyp() {
        return vita.ep.m7.Divd.super.prettyp();
    }

    public default Exp<V> multby(vita.ep.Exp<V> other) {
        return this.mult(this, this.convert(other));
    }

    public default Double eval() {
        return vita.ep.m7.Divd.super.eval();
    }

    public default Exp<V> simplify() {
        return this.convert(vita.ep.m7.Divd.super.simplify());
    }

    public default List<Double> collect() {
        return vita.ep.m7.Divd.super.collect();
    }

    public default Tree astree() {
        return vita.ep.m7.Divd.super.astree();
    }

    public default Integer id() {
        return vita.ep.m7.Divd.super.id();
    }

    public default Boolean equals(vita.ep.Exp<V> other) {
        return vita.ep.m7.Divd.super.equals(other);
    }

    public default Exp<V> powby(vita.ep.Exp<V> other) {
        return this.divd(this.getLeft().powby(this.convert(other)), this.getRight().powby(this.convert(other)));
    }
}
