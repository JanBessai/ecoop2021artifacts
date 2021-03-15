package oo.ep;

import java.util.List;
import util.Tree;

public abstract class Exp {

    public abstract String prettyp();

    public abstract oo.ep.Exp simplify();

    public abstract List<Double> collect();

    public abstract Tree astree();

    public abstract Integer id();

    public abstract Boolean equals(oo.ep.Exp other);

    public abstract oo.ep.Exp multby(oo.ep.Exp other);

    public abstract oo.ep.Exp powby(oo.ep.Exp other);

    public abstract Double eval();
}
