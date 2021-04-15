package interpreter.ep.m4;

import interpreter.ep.m2.PrettypExp;

public interface CollectSimplifyExp extends PrettypExp {

    CollectSimplifyExp simplify();

    void truncate(int level);

    java.util.List<Double> collect();
}
