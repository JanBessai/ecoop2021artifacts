package trivially.ep.m7i2;

public interface Add<V> extends trivially.ep.m7.Add<V>, trivially.ep.i2.Add<V>, Exp<V> {

    Exp<V> getLeft();
    Exp<V> getRight();

    default Exp<V> simplify() {
        return this.convert(trivially.ep.m7.Add.super.simplify());
    }

    default Exp<V> multby(trivially.ep.Exp<V> other) {
        return this.mult(this, convert(other));
    }

    default Exp<V> powby(trivially.ep.Exp<V> other) {
        return this.power(this, convert(other));
    }
}
