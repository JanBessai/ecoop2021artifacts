package trivially.ep.m0;

public interface Exp<V> extends trivially.ep.Exp<V> {

    Double eval();

    trivially.ep.m0.Exp<V> lit(Double value);

    trivially.ep.m0.Exp<V> add(trivially.ep.Exp<V> left, trivially.ep.Exp<V> right);

    trivially.ep.m0.Exp<V> convert(trivially.ep.Exp<V> other);
}
