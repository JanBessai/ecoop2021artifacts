package ev.ep.m7i2;

import ev.ep.Exp;

public class EqlPower implements VisitorMerged<Boolean> {

    protected Exp other;

    public EqlPower(Exp _other) {
        this.other = _other;
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

    public Boolean visit(ev.ep.m6.Lit exp) { return ((ev.ep.m7i2.EqlQuery)other).isLit(exp.getValue()); }
    public Boolean visit(ev.ep.m6.Add exp) { return ((ev.ep.m7i2.EqlQuery)other).isAdd((ev.ep.m7i2.EqlQuery)exp.getLeft(), (ev.ep.m7i2.EqlQuery)exp.getRight()); }
    public Boolean visit(ev.ep.m6.Sub exp) { return ((ev.ep.m7i2.EqlQuery)other).isSub((ev.ep.m7i2.EqlQuery)exp.getLeft(), (ev.ep.m7i2.EqlQuery)exp.getRight()); }
    public Boolean visit(ev.ep.m6.Neg exp) { return ((ev.ep.m7i2.EqlQuery)other).isNeg((ev.ep.m7i2.EqlQuery)exp.getInner()); }
    public Boolean visit(ev.ep.m6.Mult exp) { return ((ev.ep.m7i2.EqlQuery)other).isMult((ev.ep.m7i2.EqlQuery)exp.getLeft(), (ev.ep.m7i2.EqlQuery)exp.getRight()); }
    public Boolean visit(ev.ep.m6.Divd exp) { return ((ev.ep.m7i2.EqlQuery)other).isDivd((ev.ep.m7i2.EqlQuery)exp.getLeft(), (ev.ep.m7i2.EqlQuery)exp.getRight()); }
    public Boolean visit(ev.ep.i2.Power exp) { return ((ev.ep.m7i2.EqlQuery)other).isPower((ev.ep.m7i2.EqlQuery)exp.getLeft(), (ev.ep.m7i2.EqlQuery)exp.getRight()); }

    public Boolean visit(ev.ep.m7i2.Lit exp) { return visit((ev.ep.m6.Lit) exp); }
    public Boolean visit(ev.ep.m7i2.Add exp) { return visit((ev.ep.m6.Add) exp); }
    public Boolean visit(ev.ep.m7i2.Sub exp) { return visit((ev.ep.m6.Sub) exp); }
    public Boolean visit(ev.ep.m7i2.Neg exp) { return visit((ev.ep.m6.Neg) exp); }
    public Boolean visit(ev.ep.m7i2.Mult exp) {return visit((ev.ep.m6.Mult) exp); }
    public Boolean visit(ev.ep.m7i2.Divd exp) {return visit((ev.ep.m6.Divd) exp); }
    public Boolean visit(ev.ep.m7i2.Power exp) {return visit((ev.ep.i2.Power) exp); }

    public EqlPower makeEql(Exp _other) { return new EqlPower(_other); }
}

