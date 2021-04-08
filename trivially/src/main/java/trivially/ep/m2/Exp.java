package trivially.ep.m2;

public interface Exp<V> extends trivially.ep.m1.Exp<V> {

    String prettyp();

    trivially.ep.m2.Exp<V> sub(trivially.ep.Exp<V> left, trivially.ep.Exp<V> right);

    trivially.ep.m2.Exp<V> lit(Double value);

    trivially.ep.m2.Exp<V> add(trivially.ep.Exp<V> left, trivially.ep.Exp<V> right);

    trivially.ep.m2.Exp<V> convert(trivially.ep.Exp<V> other);
}
