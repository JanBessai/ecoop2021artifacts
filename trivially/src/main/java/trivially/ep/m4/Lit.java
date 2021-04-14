package trivially.ep.m4;

import java.util.List;

public interface Lit extends Exp, trivially.ep.m2.Lit {

    Double getValue();

    default Exp simplify() {
        return this;
    }

    default List<Double> collect() {
        return java.util.Arrays.asList(this.getValue());
    }

    default void truncate(int level) { }
}
