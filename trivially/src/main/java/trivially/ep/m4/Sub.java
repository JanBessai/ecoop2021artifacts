package trivially.ep.m4;

import java.util.List;

public interface Sub<V> extends trivially.ep.m3.Sub<V>, Exp<V> {

    Exp<V> getLeft();
    Exp<V> getRight();

    default Exp<V> simplify() {
        if (this.getLeft().eval().equals(this.getRight().eval())) {
            return this.lit(0.0);
        } else {
            return this.sub(this.getLeft().simplify(), this.getRight().simplify());
        }
    }

    default List<Double> collect() {
        return java.util.stream.Stream.concat(this.getLeft().collect().stream(), this.getRight().collect().stream()).collect(java.util.stream.Collectors.toList());
    }
}
