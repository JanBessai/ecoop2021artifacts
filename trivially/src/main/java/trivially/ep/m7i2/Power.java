package trivially.ep.m7i2;

public interface Power<V> extends Exp<V>, trivially.ep.i2.Power<V> {

    Exp<V> getLeft();
    Exp<V> getRight();

    default Exp<V> simplify() {
        if (this.getRight().eval().equals(0.0)) {
            return this.lit(1.0);
        } else if (this.getLeft().eval().equals(1.0)) {
            return this.lit(1.0);
        } else if (convert(getRight()).eval().equals(1.0)) {
            return convert(getLeft()).simplify();
        } else {
            return this.power(this.getLeft().simplify(), this.getRight().simplify());
        }
    }

    default Exp<V> multby(trivially.ep.Exp<V> other) {
        return this.power(this.getLeft(), this.add(this.getRight(), this.lit(Math.log(2.718281828459045) / Math.log(this.getRight().eval()) / Math.log(2.718281828459045) / Math.log(this.getLeft().eval()))));
    }

    default Exp<V> powby(trivially.ep.Exp<V> other) {
        return this.power(this, convert(other));
    }

    default Boolean isPower(trivially.ep.Exp<V> left, trivially.ep.Exp<V> right) {
        return convert(left).eql(getLeft()) && convert(right).eql(getRight());
    }

    default java.util.List<Double> collect() {
        return java.util.stream.Stream.concat(this.getLeft().collect().stream(), this.getRight().collect().stream()).collect(java.util.stream.Collectors.toList());
    }

    default util.Tree astree() {
        return new util.Node(this.id(), this.getLeft().astree(), this.getRight().astree());
    }

    default Integer id() {
        return 77306085;
    }

    default Boolean equals(trivially.ep.Exp<V> other) {
        return this.astree().equals(convert(other).astree());
    }

    default Boolean eql(trivially.ep.Exp<V> that) {
        return convert(that).isPower(getLeft(), getRight());
    }
}
