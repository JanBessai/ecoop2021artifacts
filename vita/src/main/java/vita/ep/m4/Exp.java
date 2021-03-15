package vita.ep.m4;

import java.util.List;

public interface Exp<V> extends vita.ep.m3.Exp<V>, Factory<V> {

    public abstract vita.ep.m4.Exp<V> simplify();

    public abstract List<Double> collect();
}
