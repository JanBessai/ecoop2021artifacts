package trivially.ep;

public interface Exp<V> {

    public abstract void accept(V visitor);

    public abstract trivially.ep.Exp<V> convert(trivially.ep.Exp<V> other);
}
