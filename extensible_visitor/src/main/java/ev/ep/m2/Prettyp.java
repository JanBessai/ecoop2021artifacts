package ev.ep.m2;

import ev.ep.m1.VisitorSub;
import ev.ep.m0.Add;
import ev.ep.m0.Lit;
import ev.ep.m1.Sub;

public class Prettyp implements VisitorSub<String> {

    public Prettyp() {
    }

    public String visit(Sub exp) {
        return "(" + exp.getLeft().accept(this.makePrettyp()) + "-" + exp.getRight().accept(this.makePrettyp()) + ")";
    }

    public String visit(Lit exp) {
        return String.valueOf(exp.getValue());
    }

    public String visit(Add exp) {
        return "(" + exp.getLeft().accept(this.makePrettyp()) + "+" + exp.getRight().accept(this.makePrettyp()) + ")";
    }

    public Prettyp makePrettyp() {
        return new Prettyp();
    }
}
