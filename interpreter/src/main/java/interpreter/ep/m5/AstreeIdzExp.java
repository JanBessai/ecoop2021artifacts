package interpreter.ep.m5;

import interpreter.ep.m4.CollectSimplifyExp;

public interface AstreeIdzExp extends CollectSimplifyExp {

    util.Tree astree();

    Integer idz();

    // producer methods must be present in all subsequent evolutions
    AstreeIdzExp simplify();

    // all subsequent data types involved in Truncate must also duplicate logic to access correct lit() factory method
}
