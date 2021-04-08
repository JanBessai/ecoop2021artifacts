package trivially.ep.m5;

import util.Tree;

public interface Exp<V> extends trivially.ep.m4.Exp<V> {

    Tree astree();

    Integer id();

    trivially.ep.m5.Exp<V> simplify();

    trivially.ep.m5.Exp<V> sub(trivially.ep.Exp<V> left, trivially.ep.Exp<V> right);

    trivially.ep.m5.Exp<V> neg(trivially.ep.Exp<V> inner);

    trivially.ep.m5.Exp<V> mult(trivially.ep.Exp<V> left, trivially.ep.Exp<V> right);

    trivially.ep.m5.Exp<V> divd(trivially.ep.Exp<V> left, trivially.ep.Exp<V> right);

    trivially.ep.m5.Exp<V> lit(Double value);

    trivially.ep.m5.Exp<V> add(trivially.ep.Exp<V> left, trivially.ep.Exp<V> right);

    trivially.ep.m5.Exp<V> convert(trivially.ep.Exp<V> other);
}
