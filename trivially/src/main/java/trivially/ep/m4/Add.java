package trivially.ep.m4;

import java.util.List;

public interface Add<V> extends trivially.ep.m3.Add<V>, Exp<V> {

    Exp<V> getLeft();
    Exp<V> getRight();

    default Exp<V> simplify() {
        if (Double.valueOf(this.getLeft().eval() + this.getRight().eval()).equals(0.0)) {
            return this.lit(0.0);
        } else if (this.getLeft().eval().equals(0.0)) {
            return this.getRight().simplify();
        } else if (this.getRight().eval().equals(0.0)) {
            return this.getLeft().simplify();
        } else {
            return this.add(this.getLeft().simplify(), this.getRight().simplify());
        }
    }

    default List<Double> collect() {
        return java.util.stream.Stream.concat(this.getLeft().collect().stream(), this.getRight().collect().stream()).collect(java.util.stream.Collectors.toList());
    }
}
