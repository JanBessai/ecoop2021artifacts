package vita.ep.m7i2;

import java.util.List;
import org.combinators.vita.ep.util.Tree;

public abstract interface Lit<V> extends vita.ep.m7.Lit<V>, vita.ep.i2.Lit<V>, Exp<V> {

    public abstract Double getValue();

    public default String prettyp() {
        return vita.ep.m7.Lit.super.prettyp();
    }

    public default Exp<V> multby(vita.ep.Exp<V> other) {
        return this.convert(vita.ep.i2.Lit.super.multby(other));
    }

    public default Double eval() {
        return vita.ep.m7.Lit.super.eval();
    }

    public default Exp<V> simplify() {
        return this.convert(vita.ep.m7.Lit.super.simplify());
    }

    public default List<Double> collect() {
        return vita.ep.m7.Lit.super.collect();
    }

    public default Tree astree() {
        return vita.ep.m7.Lit.super.astree();
    }

    public default Integer id() {
        return vita.ep.m7.Lit.super.id();
    }

    public default Boolean equals(vita.ep.Exp<V> other) {
        return vita.ep.m7.Lit.super.equals(other);
    }

    public default Exp<V> powby(vita.ep.Exp<V> other) {
        return this.convert(vita.ep.m7.Lit.super.powby(other));
    }
}
