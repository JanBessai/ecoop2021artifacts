package trivially.ep.i1;

public abstract interface Lit<V> extends trivially.ep.m6.Lit<V>, Exp<V> {

    public abstract Double getValue();

    public default Exp<V> multby(trivially.ep.Exp<V> other) {
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

    public default Exp<V> simplify() {
        return this.convert(trivially.ep.m6.Lit.super.simplify());
    }
}
