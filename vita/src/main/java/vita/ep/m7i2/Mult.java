package vita.ep.m7i2;

import java.util.List;
import org.combinators.vita.ep.util.Tree;

public abstract interface Mult<V> extends vita.ep.m7.Mult<V>, Exp<V> {

    public abstract Exp<V> getLeft();

    public abstract Exp<V> getRight();

    public default String prettyp() {
        return vita.ep.m7.Mult.super.prettyp();
    }

    public default Exp<V> multby(vita.ep.Exp<V> other) {
        return this.mult(this, this.convert(other));
    }

    public default Double eval() {
        return vita.ep.m7.Mult.super.eval();
    }

    public default Exp<V> simplify() {
        return this.convert(vita.ep.m7.Mult.super.simplify());
    }

    public default List<Double> collect() {
        return vita.ep.m7.Mult.super.collect();
    }

    public default Tree astree() {
        return vita.ep.m7.Mult.super.astree();
    }

    public default Integer id() {
        return vita.ep.m7.Mult.super.id();
    }

    public default Boolean equals(vita.ep.Exp<V> other) {
        return vita.ep.m7.Mult.super.equals(other);
    }

    public default Exp<V> powby(vita.ep.Exp<V> other) {
        return this.mult(this.getLeft().powby(this.convert(other)), this.getRight().powby(this.convert(other)));
    }
}
