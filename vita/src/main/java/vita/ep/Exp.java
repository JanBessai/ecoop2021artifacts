package vita.ep;

public interface Exp<V> extends Factory<V> {

    public abstract void accept(V visitor);
}
