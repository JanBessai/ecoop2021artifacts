package trivially.ep.m4;

import java.util.List;

public interface Lit<V> extends trivially.ep.m3.Lit<V>, Exp<V> {

    Double getValue();

    default Exp<V> simplify() {
        return this;
    }

    default List<Double> collect() {
        return java.util.Arrays.asList(this.getValue());
    }
}
