package trivially.ep.m4;

import java.util.List;

public interface Mult<V> extends trivially.ep.m3.Mult<V>, Exp<V> {

    Exp<V> getLeft();
    Exp<V> getRight();

    default Exp<V> simplify() {
        if (this.getLeft().eval().equals(0.0) || this.getRight().eval().equals(0.0)) {
            return this.lit(0.0);
        } else if (this.getLeft().eval().equals(1.0)) {
            return this.getRight().simplify();
        } else if (this.getRight().eval().equals(1.0)) {
            return this.getLeft().simplify();
        } else {
            return this.mult(this.getLeft().simplify(), this.getRight().simplify());
        }
    }

    default List<Double> collect() {
        return java.util.stream.Stream.concat(this.getLeft().collect().stream(), this.getRight().collect().stream()).collect(java.util.stream.Collectors.toList());
    }
}
