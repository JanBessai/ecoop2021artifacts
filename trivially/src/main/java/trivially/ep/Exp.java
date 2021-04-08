package trivially.ep;

public interface Exp<V> {

    void accept(V visitor);

    trivially.ep.Exp<V> convert(trivially.ep.Exp<V> other);
}
