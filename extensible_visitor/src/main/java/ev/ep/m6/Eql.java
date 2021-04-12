package ev.ep.m6;

import ev.ep.Exp;

/**
 * Eql demands that the Exp class provides default isDataType() helper methods
 * which are overridden by the respective subclasses. As such, any attempt
 * to invoke Eql on an older data type instance will fail.
 */
public class Eql implements VisitorDivdMultNegTruncateEqual<Boolean> {

    protected EqlQuery other;

    /** Any attempt to try to perform Eql with a datatype from the past will fail. */
    public Eql(Exp _other) {
        this.other = (EqlQuery) _other;
    }

    public Boolean visit(ev.ep.m0.Lit exp) {
        return visit((ev.ep.m6.Lit)exp);
    }

    // unsafe dynamic checks.
    public Boolean visit(ev.ep.m0.Add exp) {
        return visit((ev.ep.m6.Add)exp);
    }
    public Boolean visit(ev.ep.m1.Sub exp) { return visit((ev.ep.m6.Sub)exp); }
    public Boolean visit(ev.ep.m3.Neg exp) {
        return visit((ev.ep.m6.Neg)exp);
    }
    public Boolean visit(ev.ep.m3.Divd exp) {
        return visit((ev.ep.m6.Divd)exp);
    }
    public Boolean visit(ev.ep.m3.Mult exp) {
        return visit((ev.ep.m6.Mult)exp);
    }

    public Boolean visit(ev.ep.m4.Neg exp) { return visit((ev.ep.m6.Neg) exp); }
    public Boolean visit(ev.ep.m4.Mult exp) { return visit((ev.ep.m6.Mult) exp); }
    public Boolean visit(ev.ep.m4.Divd exp) { return visit((ev.ep.m6.Divd) exp); }
    public Boolean visit(ev.ep.m4.Sub exp) { return visit((ev.ep.m6.Sub) exp); }
    public Boolean visit(ev.ep.m4.Lit exp) { return visit((ev.ep.m6.Lit) exp); }
    public Boolean visit(ev.ep.m4.Add exp) { return visit((ev.ep.m6.Add) exp); }

    public Boolean visit(Neg exp) { return (other).isNeg((EqlQuery)exp.getInner());  }
    public Boolean visit(Mult exp) { return (other).isMult((EqlQuery)exp.getLeft(), (EqlQuery)exp.getRight()); }
    public Boolean visit(Divd exp) { return (other).isDivd((EqlQuery)exp.getLeft(), (EqlQuery)exp.getRight()); }
    public Boolean visit(Sub exp) { return (other).isSub((EqlQuery)exp.getLeft(), (EqlQuery)exp.getRight()); }
    public Boolean visit(Add exp) { return (other).isAdd((EqlQuery)exp.getLeft(), (EqlQuery)exp.getRight()); }
    public Boolean visit(Lit exp) { return (other).isLit(exp.getValue()); }

    public Eql makeEql(Exp _other) { return new Eql(_other); }

}
