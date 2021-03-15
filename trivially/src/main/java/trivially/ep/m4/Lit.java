package trivially.ep.m4;

import java.util.List;

public abstract interface Lit<V> extends trivially.ep.m3.Lit<V>, Exp<V> {

    public abstract Double getValue();

    public default Exp<V> simplify() {
        return this;
    }

    public default List<Double> collect() {
        return java.util.Arrays.asList(this.getValue());
    }
}
