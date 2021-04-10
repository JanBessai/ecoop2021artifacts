package ev.ep.m7i2;

import ev.ep.i2.VisitorPower;
import ev.ep.i2.Power;
import ev.ep.m0.Add;
import ev.ep.m0.Lit;
import ev.ep.m1.Sub;
import ev.ep.m3.Divd;
import ev.ep.m3.Mult;
import ev.ep.m3.Neg;

public class IdPower implements VisitorPower<Integer> {

    public IdPower() {
    }

    public Integer visit(Power exp) {
        return 77306085;
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

    public IdPower makeId() {
        return new IdPower();
    }
}
