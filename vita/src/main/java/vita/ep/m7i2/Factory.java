package vita.ep.m7i2;

import vita.ep.Exp;

public interface Factory<V> extends vita.ep.m7.Factory<V>, vita.ep.i2.Factory<V> {

    public abstract vita.ep.m7i2.Exp<V> sub(Exp<V> left, Exp<V> right);

    public abstract vita.ep.m7i2.Exp<V> power(Exp<V> left, Exp<V> right);

    public abstract vita.ep.m7i2.Exp<V> lit(Double value);

    public abstract vita.ep.m7i2.Exp<V> add(Exp<V> left, Exp<V> right);

    public abstract vita.ep.m7i2.Exp<V> neg(Exp<V> inner);

    public abstract vita.ep.m7i2.Exp<V> mult(Exp<V> left, Exp<V> right);

    public abstract vita.ep.m7i2.Exp<V> divd(Exp<V> left, Exp<V> right);

    public abstract vita.ep.m7i2.Exp<V> convert(Exp<V> other);
}
