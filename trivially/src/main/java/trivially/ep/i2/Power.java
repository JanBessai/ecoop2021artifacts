package trivially.ep.i2;

public interface Power<V> extends Exp<V> {

    Exp<V> getLeft();
    Exp<V> getRight();

    default String prettyp() {
        return "(" + this.getLeft().prettyp() + "^" + this.getRight().prettyp() + ")";
    }

    default Double eval() {
        return Math.pow(this.getLeft().eval(), this.getRight().eval());
    }

    default trivially.ep.i2.Exp<V> multby(trivially.ep.Exp<V> other) {
        double leftEval = this.convert(this.getLeft()).eval();
        double added = Math.log(convert(other).eval()) / Math.log(leftEval);
        return this.power(this.getLeft(), this.add(this.getRight(), this.lit(added)));
    }
}
