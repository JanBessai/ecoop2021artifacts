package trivially.ep.m5;

import util.Tree;

public interface Exp<V> extends trivially.ep.m4.Exp<V> {

    public abstract Tree astree();

    public abstract Integer id();

    public abstract trivially.ep.m5.Exp<V> simplify();

    public abstract trivially.ep.m5.Exp<V> sub(trivially.ep.Exp<V> left, trivially.ep.Exp<V> right);

    public abstract trivially.ep.m5.Exp<V> neg(trivially.ep.Exp<V> inner);

    public abstract trivially.ep.m5.Exp<V> mult(trivially.ep.Exp<V> left, trivially.ep.Exp<V> right);

    public abstract trivially.ep.m5.Exp<V> divd(trivially.ep.Exp<V> left, trivially.ep.Exp<V> right);

    public abstract trivially.ep.m5.Exp<V> lit(Double value);

    public abstract trivially.ep.m5.Exp<V> add(trivially.ep.Exp<V> left, trivially.ep.Exp<V> right);

    public abstract trivially.ep.m5.Exp<V> convert(trivially.ep.Exp<V> other);
}
