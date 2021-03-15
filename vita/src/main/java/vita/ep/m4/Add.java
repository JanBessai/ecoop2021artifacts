package vita.ep.m4;

import java.util.List;

public abstract interface Add<V> extends vita.ep.m3.Add<V>, Exp<V> {

    public abstract Exp<V> getLeft();

    public abstract Exp<V> getRight();

    public default String prettyp() {
        return vita.ep.m3.Add.super.prettyp();
    }

    public default Exp<V> simplify() {
        if (Double.valueOf(this.getLeft().eval() + this.getRight().eval()).equals(0.0)) {
            return this.lit(0.0);
        } else if (Double.valueOf(this.getLeft().eval()).equals(0.0)) {
            return this.getRight().simplify();
        } else if (Double.valueOf(this.getRight().eval()).equals(0.0)) {
            return this.getLeft().simplify();
        } else {
            return this.add(this.getLeft().simplify(), this.getRight().simplify());
        }
    }

    public default List<Double> collect() {
        return java.util.stream.Stream.concat(this.getLeft().collect().stream(), this.getRight().collect().stream()).collect(java.util.stream.Collectors.toList());
    }

    public default Double eval() {
        return vita.ep.m3.Add.super.eval();
    }
}
