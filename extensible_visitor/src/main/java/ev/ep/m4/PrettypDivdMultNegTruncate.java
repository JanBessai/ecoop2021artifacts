package ev.ep.m4;

import ev.ep.Exp;
import ev.ep.m2.Prettyp;

public class PrettypDivdMultNegTruncate extends Prettyp implements VisitorDivdMultNegTruncate<String> {

    public PrettypDivdMultNegTruncate() {
    }

    // unsafe runtime exceptions
    public String visit(ev.ep.m0.Lit exp) {
        return visit((ev.ep.m4.Lit)exp);
    }
    public String visit(ev.ep.m0.Add exp) {
        return visit((ev.ep.m4.Add)exp);
    }
    public String visit(ev.ep.m1.Sub exp) {
        return visit((ev.ep.m4.Sub)exp);
    }
    public String visit(ev.ep.m3.Neg exp) {
        return visit((ev.ep.m4.Neg)exp);
    }
    public String visit(ev.ep.m3.Divd exp) {
        return visit((ev.ep.m4.Divd)exp);
    }
    public String visit(ev.ep.m3.Mult exp) {
        return visit((ev.ep.m4.Mult)exp);
    }

    public String visit(Neg exp) {
        return "(-" + exp.getInner().accept(this.makePrettyp()) + ")";
    }

    public String visit(Mult exp) {
        return "(" + exp.getLeft().accept(this.makePrettyp()) + "*" + exp.getRight().accept(this.makePrettyp()) + ")";
    }

    public String visit(Divd exp) {
        return "(" + exp.getLeft().accept(this.makePrettyp()) + "/" + exp.getRight().accept(this.makePrettyp()) + ")";
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

    public PrettypDivdMultNegTruncate makePrettyp() {
        return new PrettypDivdMultNegTruncate();
    }
}
