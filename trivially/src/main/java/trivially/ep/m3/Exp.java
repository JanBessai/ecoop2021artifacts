package trivially.ep.m3;

public interface Exp<V> extends trivially.ep.m2.Exp<V> {

    trivially.ep.m3.Exp<V> sub(trivially.ep.Exp<V> left, trivially.ep.Exp<V> right);

    trivially.ep.m3.Exp<V> neg(trivially.ep.Exp<V> inner);

    trivially.ep.m3.Exp<V> mult(trivially.ep.Exp<V> left, trivially.ep.Exp<V> right);

    trivially.ep.m3.Exp<V> divd(trivially.ep.Exp<V> left, trivially.ep.Exp<V> right);

    trivially.ep.m3.Exp<V> lit(Double value);

    trivially.ep.m3.Exp<V> add(trivially.ep.Exp<V> left, trivially.ep.Exp<V> right);

    trivially.ep.m3.Exp<V> convert(trivially.ep.Exp<V> other);
}
