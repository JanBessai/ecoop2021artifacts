package vita.ep.m7i2;

import java.util.List;
import org.combinators.vita.ep.util.Node;
import org.combinators.vita.ep.util.Tree;

public abstract interface Power<V> extends vita.ep.i2.Power<V>, Exp<V> {

    public abstract Exp<V> getLeft();

    public abstract Exp<V> getRight();

    public default String prettyp() {
        return vita.ep.i2.Power.super.prettyp();
    }

    public default Exp<V> multby(vita.ep.Exp<V> other) {
        return this.convert(vita.ep.i2.Power.super.multby(other));
    }

    public default Double eval() {
        return vita.ep.i2.Power.super.eval();
    }

    public default Exp<V> simplify() {
        if (Double.valueOf(this.getRight().eval()).equals(0.0)) {
            return this.lit(1.0);
        } else if (Double.valueOf(this.getLeft().eval()).equals(1.0)) {
            return this.lit(1.0);
        } else {
            return this.power(this.getLeft().simplify(), this.getRight().simplify());
        }
    }

    public default List<Double> collect() {
        return java.util.stream.Stream.concat(this.getLeft().collect().stream(), this.getRight().collect().stream()).collect(java.util.stream.Collectors.toList());
    }

    public default Tree astree() {
        return new Node(this.id(), this.getLeft().astree(), this.getRight().astree());
    }

    public default Integer id() {
        return 77306085;
    }

    public default Boolean equals(vita.ep.Exp<V> other) {
        return this.astree().equals(this.convert(other).astree());
    }

    public default Exp<V> powby(vita.ep.Exp<V> other) {
        return this.power(this, this.convert(other));
    }
}
