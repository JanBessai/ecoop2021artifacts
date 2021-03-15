package vita.ep.i1;

public abstract interface Lit<V> extends vita.ep.m2.Lit<V>, Exp<V> {

    public abstract Double getValue();

    public default String prettyp() {
        return vita.ep.m2.Lit.super.prettyp();
    }

    public default Exp<V> multby(vita.ep.Exp<V> other) {
        Exp<V> result = this.convert(other);
        Double counter = Math.floor(Math.abs(this.getValue()));
        while (1.0 < counter) {
            result = this.add(result, this.convert(other));
            counter = counter - 1.0;
        }
        if (this.getValue() < 0.0) {
            result = this.sub(this.lit(0.0), result);
        }
        return result;
    }

    public default Double eval() {
        return vita.ep.m2.Lit.super.eval();
    }
}
