package vita.ep.m4;

import java.util.List;

public abstract interface Lit<V> extends vita.ep.m3.Lit<V>, Exp<V> {

    public abstract Double getValue();

    public default String prettyp() {
        return vita.ep.m3.Lit.super.prettyp();
    }

    public default Exp<V> simplify() {
        return this;
    }

    public default List<Double> collect() {
        return java.util.Arrays.asList(this.getValue());
    }

    public default Double eval() {
        return vita.ep.m3.Lit.super.eval();
    }
}
