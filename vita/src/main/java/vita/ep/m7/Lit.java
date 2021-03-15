package vita.ep.m7;

import java.util.List;
import org.combinators.vita.ep.util.Tree;

public abstract interface Lit<V> extends vita.ep.m6.Lit<V>, Exp<V> {

    public abstract Double getValue();

    public default String prettyp() {
        return vita.ep.m6.Lit.super.prettyp();
    }

    public default Exp<V> simplify() {
        return this.convert(vita.ep.m6.Lit.super.simplify());
    }

    public default List<Double> collect() {
        return vita.ep.m6.Lit.super.collect();
    }

    public default Tree astree() {
        return vita.ep.m6.Lit.super.astree();
    }

    public default Integer id() {
        return vita.ep.m6.Lit.super.id();
    }

    public default Boolean equals(vita.ep.Exp<V> other) {
        return vita.ep.m6.Lit.super.equals(other);
    }

    public default Exp<V> powby(vita.ep.Exp<V> other) {
        Double exponentValue = this.convert(other).eval();
        Exp<V> result = this;
        Double counter = Math.floor(Math.abs(exponentValue));
        while (1.0 < counter) {
            result = this.mult(result, this);
            counter = counter - 1.0;
        }
        if (this.getValue() < 0.0) {
            result = this.divd(this.lit(1.0), result);
        }
        return result;
    }

    public default Double eval() {
        return vita.ep.m6.Lit.super.eval();
    }
}
