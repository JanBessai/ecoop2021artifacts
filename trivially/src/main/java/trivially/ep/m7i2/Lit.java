package trivially.ep.m7i2;

public interface Lit<V> extends trivially.ep.m7.Lit<V>, trivially.ep.i2.Lit<V>, Exp<V> {

    Double getValue();

    default Exp<V> simplify() {
        return convert(trivially.ep.m7.Lit.super.simplify());
    }

    default Exp<V> multby(trivially.ep.Exp<V> other) {
        return this.mult(this, convert(other));
    }

    default Exp<V> powby(trivially.ep.Exp<V> other) {
        return this.power(this, convert(other));
    }
}
