package ev.ep.m7i2;

import ev.ep.Exp;
import ev.ep.i2.Power;
import ev.ep.m7.PowBy;

public class PowByMerged extends PowBy implements VisitorMerged<Exp> {

    public PowByMerged(Exp _other) {
        super(_other);
    }

    // in Merged Branch, we can take advantage of Power!
    public Exp visit(ev.ep.m0.Lit exp) { return new Power(exp, this.other); }
    public Exp visit(ev.ep.m0.Add exp) { return new ev.ep.i2.Power(exp, this.other); }
    public Exp visit(ev.ep.m1.Sub exp) { return new ev.ep.i2.Power(exp, this.other); }
    public Exp visit(ev.ep.m3.Mult exp) { return new ev.ep.i2.Power(exp, this.other); }
    public Exp visit(ev.ep.m3.Neg exp) { return new ev.ep.i2.Power(exp, this.other); }
    public Exp visit(ev.ep.m3.Divd exp) { return new ev.ep.i2.Power(exp, this.other); }
    public Exp visit(ev.ep.i2.Power exp) { return new ev.ep.i2.Power(exp, this.other); }

}
