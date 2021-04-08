package trivially.ep.m4;

import java.util.List;

public interface Exp<V> extends trivially.ep.m3.Exp<V> {

    trivially.ep.m4.Exp<V> simplify();

    List<Double> collect();

    trivially.ep.m4.Exp<V> sub(trivially.ep.Exp<V> left, trivially.ep.Exp<V> right);

    trivially.ep.m4.Exp<V> neg(trivially.ep.Exp<V> inner);

    trivially.ep.m4.Exp<V> mult(trivially.ep.Exp<V> left, trivially.ep.Exp<V> right);

    trivially.ep.m4.Exp<V> divd(trivially.ep.Exp<V> left, trivially.ep.Exp<V> right);

    trivially.ep.m4.Exp<V> lit(Double value);

    trivially.ep.m4.Exp<V> add(trivially.ep.Exp<V> left, trivially.ep.Exp<V> right);

    trivially.ep.m4.Exp<V> convert(trivially.ep.Exp<V> other);
}
