package trivially.ep.m7;

public abstract interface Lit<V> extends trivially.ep.i1.Lit<V>, Exp<V> {

    public abstract Double getValue();

    public default Exp<V> powby(trivially.ep.Exp<V> other) {
        Double exponentValue = this.convert(other).eval();
        Exp<V> result = this;
        Double counter = Math.floor(Math.abs(exponentValue));
        while (1.0 < counter) {
            result = this.mult(result, this);
            counter = counter - 1.0;
        }
        if (this.getValue() < 0.0) {
            result = this.divd(this.lit(1.0), result);
        }
        return result;
    }

    public default Exp<V> simplify() {
        return this.convert(trivially.ep.i1.Lit.super.simplify());
    }

    public default Exp<V> multby(trivially.ep.Exp<V> other) {
        return this.convert(trivially.ep.i1.Lit.super.multby(other));
    }
}
