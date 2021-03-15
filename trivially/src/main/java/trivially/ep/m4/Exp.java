package trivially.ep.m4;

import java.util.List;

public interface Exp<V> extends trivially.ep.m3.Exp<V> {

    public abstract trivially.ep.m4.Exp<V> simplify();

    public abstract List<Double> collect();

    public abstract trivially.ep.m4.Exp<V> sub(trivially.ep.Exp<V> left, trivially.ep.Exp<V> right);

    public abstract trivially.ep.m4.Exp<V> neg(trivially.ep.Exp<V> inner);

    public abstract trivially.ep.m4.Exp<V> mult(trivially.ep.Exp<V> left, trivially.ep.Exp<V> right);

    public abstract trivially.ep.m4.Exp<V> divd(trivially.ep.Exp<V> left, trivially.ep.Exp<V> right);

    public abstract trivially.ep.m4.Exp<V> lit(Double value);

    public abstract trivially.ep.m4.Exp<V> add(trivially.ep.Exp<V> left, trivially.ep.Exp<V> right);

    public abstract trivially.ep.m4.Exp<V> convert(trivially.ep.Exp<V> other);
}
