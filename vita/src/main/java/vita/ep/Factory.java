package vita.ep;

public interface Factory<V> {

    public abstract Exp<V> convert(Exp<V> other);
}
