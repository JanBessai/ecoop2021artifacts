package vita.ep.m7;

import java.util.List;
import org.combinators.vita.ep.util.Tree;

public abstract interface Neg<V> extends vita.ep.m6.Neg<V>, Exp<V> {

    public abstract Exp<V> getInner();

    public default String prettyp() {
        return vita.ep.m6.Neg.super.prettyp();
    }

    public default Exp<V> simplify() {
        return this.convert(vita.ep.m6.Neg.super.simplify());
    }

    public default List<Double> collect() {
        return vita.ep.m6.Neg.super.collect();
    }

    public default Tree astree() {
        return vita.ep.m6.Neg.super.astree();
    }

    public default Integer id() {
        return vita.ep.m6.Neg.super.id();
    }

    public default Boolean equals(vita.ep.Exp<V> other) {
        return vita.ep.m6.Neg.super.equals(other);
    }

    public default Exp<V> powby(vita.ep.Exp<V> other) {
        return this.mult(this.lit(1.0).powby(this.getInner()), this.getInner().powby(this.convert(other)));
    }

    public default Double eval() {
        return vita.ep.m6.Neg.super.eval();
    }
}
