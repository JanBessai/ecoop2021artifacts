package trivially.ep.m1;

public interface Add<V> extends trivially.ep.m0.Add<V>, Exp<V> {

    Exp<V> getLeft();
    Exp<V> getRight();
}
