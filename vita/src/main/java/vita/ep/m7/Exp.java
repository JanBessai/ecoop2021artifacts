package vita.ep.m7;

public interface Exp<V> extends vita.ep.m6.Exp<V>, Factory<V> {

    public abstract vita.ep.m7.Exp<V> powby(vita.ep.Exp<V> other);

    public abstract vita.ep.m7.Exp<V> simplify();
}
