package trivially.ep.m1;

public interface Exp<V> extends trivially.ep.m0.Exp<V> {

    trivially.ep.m1.Exp<V> sub(trivially.ep.Exp<V> left, trivially.ep.Exp<V> right);

    trivially.ep.m1.Exp<V> lit(Double value);

    trivially.ep.m1.Exp<V> add(trivially.ep.Exp<V> left, trivially.ep.Exp<V> right);

    trivially.ep.m1.Exp<V> convert(trivially.ep.Exp<V> other);
}
