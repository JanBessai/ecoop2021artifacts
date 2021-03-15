package trivially.ep.i2;

import java.util.List;
import util.Node;
import util.Tree;

public abstract interface Power<V> extends Exp<V> {

    public abstract Exp<V> getLeft();

    public abstract Exp<V> getRight();

    public default String prettyp() {
        return "(" + this.getLeft().prettyp() + "^" + this.getRight().prettyp() + ")";
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

    public default Boolean equals(trivially.ep.Exp<V> other) {
        return this.astree().equals(this.convert(other).astree());
    }

    public default Exp<V> multby(trivially.ep.Exp<V> other) {
        return this.power(this.getLeft(), this.add(this.getRight(), this.lit(Math.log(2.718281828459045) / Math.log(this.getRight().eval()) / Math.log(2.718281828459045) / Math.log(this.getLeft().eval()))));
    }

    public default Exp<V> powby(trivially.ep.Exp<V> other) {
        return this.power(this, this.convert(other));
    }

    public default Double eval() {
        return Math.pow(this.getLeft().eval(), this.getRight().eval());
    }
}
