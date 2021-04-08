package trivially.ep.m7;

public interface Exp<V> extends trivially.ep.m6.Exp<V> {

    trivially.ep.m7.Exp<V> powby(trivially.ep.Exp<V> other);

    trivially.ep.m7.Exp<V> simplify();

    trivially.ep.m7.Exp<V> sub(trivially.ep.Exp<V> left, trivially.ep.Exp<V> right);

    trivially.ep.m7.Exp<V> neg(trivially.ep.Exp<V> inner);

    trivially.ep.m7.Exp<V> mult(trivially.ep.Exp<V> left, trivially.ep.Exp<V> right);

    trivially.ep.m7.Exp<V> divd(trivially.ep.Exp<V> left, trivially.ep.Exp<V> right);

    trivially.ep.m7.Exp<V> lit(Double value);

    trivially.ep.m7.Exp<V> add(trivially.ep.Exp<V> left, trivially.ep.Exp<V> right);

    trivially.ep.m7.Exp<V> convert(trivially.ep.Exp<V> other);
}
