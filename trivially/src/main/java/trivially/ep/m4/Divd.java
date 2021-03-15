package trivially.ep.m4;

import java.util.List;

public abstract interface Divd<V> extends trivially.ep.m3.Divd<V>, Exp<V> {

    public abstract Exp<V> getLeft();

    public abstract Exp<V> getRight();

    public default Exp<V> simplify() {
        if (Double.valueOf(this.getLeft().eval()).equals(0.0)) {
            return this.lit(0.0);
        } else if (Double.valueOf(this.getRight().eval()).equals(1.0)) {
            return this.getLeft().simplify();
        } else if (Double.valueOf(this.getLeft().eval()).equals(this.getRight().eval())) {
            return this.lit(1.0);
        } else if (Double.valueOf(this.getLeft().eval()).equals(-1.0 * this.getRight().eval())) {
            return this.lit(-1.0);
        } else {
            return this.divd(this.getLeft().simplify(), this.getRight().simplify());
        }
    }

    public default List<Double> collect() {
        return java.util.stream.Stream.concat(this.getLeft().collect().stream(), this.getRight().collect().stream()).collect(java.util.stream.Collectors.toList());
    }
}
