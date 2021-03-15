package vita.ep.m4;

import java.util.List;

public abstract interface Neg<V> extends vita.ep.m3.Neg<V>, Exp<V> {

    public abstract Exp<V> getInner();

    public default String prettyp() {
        return vita.ep.m3.Neg.super.prettyp();
    }

    public default Exp<V> simplify() {
        if (Double.valueOf(this.getInner().eval()).equals(0.0)) {
            return this.lit(0.0);
        } else {
            return this.neg(this.getInner().simplify());
        }
    }

    public default List<Double> collect() {
        return this.getInner().collect();
    }

    public default Double eval() {
        return vita.ep.m3.Neg.super.eval();
    }
}
