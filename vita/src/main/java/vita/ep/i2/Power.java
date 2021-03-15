package vita.ep.i2;

public abstract interface Power<V> extends Exp<V> {

    public abstract Exp<V> getLeft();

    public abstract Exp<V> getRight();

    public default String prettyp() {
        return "(" + this.getLeft().prettyp() + "^" + this.getRight().prettyp() + ")";
    }

    public default Exp<V> multby(vita.ep.Exp<V> other) {
        return this.power(this.getLeft(), this.add(this.getRight(), this.lit(Math.log(2.718281828459045) / Math.log(this.getRight().eval()) / Math.log(2.718281828459045) / Math.log(this.getLeft().eval()))));
    }

    public default Double eval() {
        return Math.pow(this.getLeft().eval(), this.getRight().eval());
    }
}
