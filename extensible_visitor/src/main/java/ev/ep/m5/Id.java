package ev.ep.m5;

import ev.ep.m4.*;

public class Id implements VisitorDivdMultNegTruncate<Integer> {

    public Id() { }

    // unsafe runtime exceptions
    public Integer visit(ev.ep.m0.Lit exp) { return visit((ev.ep.m4.Lit)exp); }
    public Integer visit(ev.ep.m0.Add exp) {
        return visit((ev.ep.m4.Add)exp);
    }
    public Integer visit(ev.ep.m1.Sub exp) {
        return visit((ev.ep.m4.Sub)exp);
    }
    public Integer visit(ev.ep.m3.Neg exp) {
        return visit((ev.ep.m4.Neg)exp);
    }
    public Integer visit(ev.ep.m3.Divd exp) {
        return visit((ev.ep.m4.Divd)exp);
    }
    public Integer visit(ev.ep.m3.Mult exp) {
        return visit((ev.ep.m4.Mult)exp);
    }

    public Integer visit(Neg exp) {
        return 78192;
    }

    public Integer visit(Mult exp) {
        return 2409808;
    }

    public Integer visit(Divd exp) {
        return 2130451;
    }

    public Integer visit(Sub exp) {
        return 83488;
    }

    public Integer visit(Lit exp) {
        return 76407;
    }

    public Integer visit(Add exp) {
        return 65665;
    }

    public Id makeId() {
        return new Id();
    }
}
