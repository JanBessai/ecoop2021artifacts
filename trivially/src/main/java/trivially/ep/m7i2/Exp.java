package trivially.ep.m7i2;

public interface Exp<V> extends trivially.ep.i2.Exp<V>,trivially.ep.m7.Exp<V> {

    default Boolean isPower(trivially.ep.Exp<V> left, trivially.ep.Exp<V> right) { return false; }

    trivially.ep.m7i2.Exp<V> simplify();

    trivially.ep.m7i2.Exp<V> multby(trivially.ep.Exp<V> other);

    trivially.ep.m7i2.Exp<V> powby(trivially.ep.Exp<V> other);

    trivially.ep.m7i2.Exp<V> sub(trivially.ep.Exp<V> left, trivially.ep.Exp<V> right);

    trivially.ep.m7i2.Exp<V> neg(trivially.ep.Exp<V> inner);

    trivially.ep.m7i2.Exp<V> mult(trivially.ep.Exp<V> left, trivially.ep.Exp<V> right);

    trivially.ep.m7i2.Exp<V> divd(trivially.ep.Exp<V> left, trivially.ep.Exp<V> right);

    trivially.ep.m7i2.Exp<V> power(trivially.ep.Exp<V> left, trivially.ep.Exp<V> right);

    trivially.ep.m7i2.Exp<V> lit(Double value);

    trivially.ep.m7i2.Exp<V> add(trivially.ep.Exp<V> left, trivially.ep.Exp<V> right);

    trivially.ep.m7i2.Exp<V> convert(trivially.ep.Exp<V> other);
}
