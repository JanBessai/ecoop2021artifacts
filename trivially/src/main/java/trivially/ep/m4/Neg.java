package trivially.ep.m4;

import java.util.List;

public interface Neg<V> extends trivially.ep.m3.Neg<V>, Exp<V> {

    Exp<V> getInner();

    default Exp<V> simplify() {
        if (this.getInner().eval().equals(0.0)) {
            return this.lit(0.0);
        } else {
            return this.neg(this.getInner().simplify());
        }
    }

    default List<Double> collect() {
        return this.getInner().collect();
    }
}
