package vita.ep.m7;

import vita.ep.Exp;

public interface Factory<V> extends vita.ep.m6.Factory<V> {

    public abstract vita.ep.m7.Exp<V> sub(Exp<V> left, Exp<V> right);

    public abstract vita.ep.m7.Exp<V> neg(Exp<V> inner);

    public abstract vita.ep.m7.Exp<V> mult(Exp<V> left, Exp<V> right);

    public abstract vita.ep.m7.Exp<V> divd(Exp<V> left, Exp<V> right);

    public abstract vita.ep.m7.Exp<V> lit(Double value);

    public abstract vita.ep.m7.Exp<V> add(Exp<V> left, Exp<V> right);

    public abstract vita.ep.m7.Exp<V> convert(Exp<V> other);
}
