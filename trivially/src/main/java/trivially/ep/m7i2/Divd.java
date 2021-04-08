package trivially.ep.m7i2;

public interface Divd<V> extends trivially.ep.m7.Divd<V>, Exp<V> {

    Exp<V> getLeft();
    Exp<V> getRight();

    default Exp<V> simplify() {
        return convert(trivially.ep.m7.Divd.super.simplify());
    }

    default Exp<V> multby(trivially.ep.Exp<V> other) {
        return this.mult(this, convert(other));
    }

    default Exp<V> powby(trivially.ep.Exp<V> other) {
        return this.power(this, convert(other));
    }
}
