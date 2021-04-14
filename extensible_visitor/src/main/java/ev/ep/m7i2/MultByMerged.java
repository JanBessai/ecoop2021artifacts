package ev.ep.m7i2;

import ev.ep.Exp;
import ev.ep.i1.MultBy;
import ev.ep.i2.EvalPower;
import ev.ep.i2.MultByPower;
import ev.ep.i2.Power;

public class MultByMerged extends MultByPower implements VisitorMerged<Exp> {

    public MultByMerged(Exp _other) {
       super(_other);
    }
    public Exp visit(ev.ep.m0.Lit exp) { return new ev.ep.m3.Mult(exp, this.other); }
    public Exp visit(ev.ep.m0.Add exp) { return new ev.ep.m3.Mult(exp, this.other); }
    public Exp visit(ev.ep.m1.Sub exp) { return new ev.ep.m3.Mult(exp, this.other); }
    public Exp visit(ev.ep.m3.Mult exp) { return new ev.ep.m3.Mult(exp, this.other); }
    public Exp visit(ev.ep.m3.Neg exp) { return new ev.ep.m3.Mult(exp, this.other); }
    public Exp visit(ev.ep.m3.Divd exp) { return new ev.ep.m3.Mult(exp, this.other); }
    public Exp visit(ev.ep.i2.Power exp) { return new ev.ep.m3.Mult(exp, this.other); }
}
