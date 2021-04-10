package ev.ep.m6;

import ev.ep.Exp;
import ev.ep.m3.VisitorDivdMultNeg;
import ev.ep.m0.Add;
import ev.ep.m0.Lit;
import ev.ep.m1.Sub;
import ev.ep.m3.Divd;
import ev.ep.m3.Mult;
import ev.ep.m3.Neg;
import ev.ep.m5.Astree;

public class Equals implements VisitorDivdMultNeg<Boolean> {

    protected Exp other;

    public Equals(Exp _other) {
        this.other = _other;
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

    public Astree makeAstree() {
        return new Astree();
    }

    public Equals makeEquals(Exp _other) {
        return new Equals(_other);
    }
}
