package ev.ep.m7i2;

import ev.ep.Exp;
import ev.ep.i2.VisitorPower;
import ev.ep.i2.Power;
import ev.ep.m0.Add;
import ev.ep.m0.Lit;
import ev.ep.m1.Sub;
import ev.ep.m3.Divd;
import ev.ep.m3.Mult;
import ev.ep.m3.Neg;

public class EqualsPower implements VisitorPower<Boolean> {

    protected Exp other;

    public EqualsPower(Exp _other) {
        this.other = _other;
    }

    public Boolean visit(Power exp) {
        return exp.accept(this.makeAstree()).equals(this.other.accept(this.makeAstree()));
    }

    public Boolean visit(Neg exp) {
        return exp.accept(this.makeAstree()).equals(this.other.accept(this.makeAstree()));
    }

    public Boolean visit(Mult exp) {
        return exp.accept(this.makeAstree()).equals(this.other.accept(this.makeAstree()));
    }

    public Boolean visit(Divd exp) {
        return exp.accept(this.makeAstree()).equals(this.other.accept(this.makeAstree()));
    }

    public Boolean visit(Sub exp) {
        return exp.accept(this.makeAstree()).equals(this.other.accept(this.makeAstree()));
    }

    public Boolean visit(Lit exp) {
        return exp.accept(this.makeAstree()).equals(this.other.accept(this.makeAstree()));
    }

    public Boolean visit(Add exp) {
        return exp.accept(this.makeAstree()).equals(this.other.accept(this.makeAstree()));
    }

    public AstreePower makeAstree() {
        return new AstreePower();
    }

    public EqualsPower makeEquals(Exp _other) {
        return new EqualsPower(_other);
    }
}
