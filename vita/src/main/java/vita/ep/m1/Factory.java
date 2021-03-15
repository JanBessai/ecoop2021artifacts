package vita.ep.m1;

import vita.ep.Exp;

public interface Factory<V> extends vita.ep.m0.Factory<V> {

    public abstract vita.ep.m1.Exp<V> sub(Exp<V> left, Exp<V> right);

    public abstract vita.ep.m1.Exp<V> lit(Double value);

    public abstract vita.ep.m1.Exp<V> add(Exp<V> left, Exp<V> right);

    public abstract vita.ep.m1.Exp<V> convert(Exp<V> other);
}
