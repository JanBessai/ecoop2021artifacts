package trivially.ep.i2;

public interface Exp<V> extends trivially.ep.i1.Exp<V> {

    trivially.ep.i2.Exp<V> lit(Double value);

    trivially.ep.i2.Exp<V> add(trivially.ep.Exp<V> left, trivially.ep.Exp<V> right);

    trivially.ep.i2.Exp<V> sub(trivially.ep.Exp<V> left, trivially.ep.Exp<V> right);

    trivially.ep.i2.Exp<V> power(trivially.ep.Exp<V> left, trivially.ep.Exp<V> right);

    trivially.ep.i2.Exp<V> multby(trivially.ep.Exp<V> other);

    trivially.ep.i2.Exp<V> convert(trivially.ep.Exp<V> other);
}
