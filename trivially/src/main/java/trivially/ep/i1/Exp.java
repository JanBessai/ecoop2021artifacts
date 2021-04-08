package trivially.ep.i1;

public interface Exp<V> extends trivially.ep.m2.Exp<V> {

    trivially.ep.i1.Exp<V> lit(Double value);

    trivially.ep.i1.Exp<V> add(trivially.ep.Exp<V> left, trivially.ep.Exp<V> right);

    trivially.ep.i1.Exp<V> sub(trivially.ep.Exp<V> left, trivially.ep.Exp<V> right);

    trivially.ep.i1.Exp<V> multby(trivially.ep.Exp<V> other);

    trivially.ep.i1.Exp<V> convert(trivially.ep.Exp<V> other);
}
