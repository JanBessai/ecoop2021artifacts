package trivially.ep.m7;

public interface Lit<V> extends trivially.ep.m6.Lit<V>, Exp<V> {

    Double getValue();

    default Exp<V> powby(trivially.ep.Exp<V> other) {
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

    default Exp<V> simplify() {
        return this.convert(trivially.ep.m6.Lit.super.simplify());
    }

}
