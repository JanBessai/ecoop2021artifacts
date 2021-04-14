package ev.ep.m5;

import ev.ep.m3.VisitorDivdMultNeg;

public class Id implements VisitorDivdMultNeg<Integer> {

    public Id() { }

    public Integer visit(ev.ep.m0.Lit exp) { return 76407;  }
    public Integer visit(ev.ep.m0.Add exp) { return 65665;  }
    public Integer visit(ev.ep.m1.Sub exp) {
        return 83488;
    }
    public Integer visit(ev.ep.m3.Neg exp) {
        return 78192;
    }
    public Integer visit(ev.ep.m3.Divd exp) {
        return 2130451;
    }
    public Integer visit(ev.ep.m3.Mult exp) {
        return 2409808;
    }

}
