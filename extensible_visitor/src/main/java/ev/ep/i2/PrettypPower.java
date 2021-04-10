package ev.ep.i2;

import ev.ep.m2.Prettyp;

public class PrettypPower extends Prettyp implements VisitorPower<String> {

    public PrettypPower() { }

    public String visit(Power exp) {
        return "(" + exp.getLeft().accept(this.makePrettyp()) + "^" + exp.getRight().accept(this.makePrettyp()) + ")";
    }

    public PrettypPower makePrettyp() { return new PrettypPower(); }
}