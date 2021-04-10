package ev.ep.m6;

import ev.ep.Exp;

public class Eql implements VisitorDivdMultNegTruncateEqual<Boolean> {

    protected Exp other;

    public Eql(Exp _other) {
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

    public Boolean visit(Neg exp) { return ((EqlQuery)other).isNeg((EqlQuery)exp.getInner());  }
    public Boolean visit(Mult exp) { return ((EqlQuery)other).isMult((EqlQuery)exp.getLeft(), (EqlQuery)exp.getRight()); }
    public Boolean visit(Divd exp) { return ((EqlQuery)other).isDivd((EqlQuery)exp.getLeft(), (EqlQuery)exp.getRight()); }
    public Boolean visit(Sub exp) { return ((EqlQuery)other).isSub((EqlQuery)exp.getLeft(), (EqlQuery)exp.getRight()); }
    public Boolean visit(Add exp) { return ((EqlQuery)other).isAdd((EqlQuery)exp.getLeft(), (EqlQuery)exp.getRight()); }
    public Boolean visit(Lit exp) { return ((EqlQuery)other).isLit(exp.getValue()); }

    public Eql makeEql(Exp _other) { return new Eql(_other); }

}
