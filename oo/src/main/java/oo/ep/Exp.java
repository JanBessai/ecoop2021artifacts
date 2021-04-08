package oo.ep;

import java.util.List;
import util.Tree;

public abstract class Exp {

    public abstract String prettyp();

    public abstract oo.ep.Exp simplify();

    public abstract List<Double> collect();

    public abstract void truncate (int level);

    public abstract Tree astree();

    public abstract Integer id();

    public abstract Boolean equals(oo.ep.Exp other);

    public Boolean isLit(Double d) { return false; }
    public Boolean isAdd(Exp left, Exp right) { return false; }
    public Boolean isSub(Exp left, Exp right) { return false; }
    public Boolean isMult(Exp left, Exp right) { return false; }
    public Boolean isNeg(Exp inner) { return false; }
    public Boolean isDivd(Exp left, Exp right) { return false; }
    public Boolean isPower(Exp left, Exp right) { return false; }

    public abstract Boolean eql(Exp other);

    public abstract oo.ep.Exp multby(oo.ep.Exp other);

    public abstract oo.ep.Exp powby(oo.ep.Exp other);

    public abstract Double eval();
}
