package vita.ep.m5;

import org.combinators.vita.ep.util.Tree;

public interface Exp<V> extends vita.ep.m4.Exp<V>, Factory<V> {

    public abstract Tree astree();

    public abstract Integer id();

    public abstract vita.ep.m5.Exp<V> simplify();
}
