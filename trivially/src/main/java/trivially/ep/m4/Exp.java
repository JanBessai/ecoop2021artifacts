package trivially.ep.m4;

import java.util.List;

public interface Exp extends trivially.ep.m2.Exp {

    trivially.ep.m4.Exp simplify();
    void truncate(int level);

    List<Double> collect();
}
