package trivially.ep.m5;

import util.Tree;

public interface Exp extends trivially.ep.m4.Exp {

    Tree astree();

    Integer id();

    // Producer methods must be covariantly overridden
    trivially.ep.m5.Exp simplify();

    // note each data type must provide new truncate implementation to access new finalized data type implementations

}
