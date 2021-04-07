package interpreter.ep.m5;

import interpreter.ep.m4.CollectSimplifyExp;

public interface AstreeIdzExp extends CollectSimplifyExp {

    util.Tree astree();

    Integer idz();
}
