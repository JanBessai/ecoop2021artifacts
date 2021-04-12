package ev.ep.m4;

import ev.ep.m2.Prettyp;

public class PrettypDivdMultNegTruncate extends Prettyp implements VisitorDivdMultNegTruncate<String> {

    public PrettypDivdMultNegTruncate() {
    }

    public String visit(ev.ep.m0.Lit exp) {
        return String.valueOf(exp.getValue());
    }
    public String visit(ev.ep.m0.Add exp) {
        return "(" + exp.getLeft().accept(this.makePrettyp()) + "+" + exp.getRight().accept(this.makePrettyp()) + ")";
    }
    public String visit(ev.ep.m1.Sub exp) {
        return "(" + exp.getLeft().accept(this.makePrettyp()) + "-" + exp.getRight().accept(this.makePrettyp()) + ")";
    }
    public String visit(ev.ep.m3.Mult exp) {
        return "(" + exp.getLeft().accept(this.makePrettyp()) + "*" + exp.getRight().accept(this.makePrettyp()) + ")";
    }

    public String visit(ev.ep.m3.Neg exp) {
        return "(-" + exp.getInner().accept(this.makePrettyp()) + ")";
    }

    public String visit(ev.ep.m3.Divd exp) {
        return "(" + exp.getLeft().accept(this.makePrettyp()) + "/" + exp.getRight().accept(this.makePrettyp()) + ")";
    }

    public String visit(Lit exp) {
        return String.valueOf(exp.getValue());
    }

    public String visit(Add exp) {
        return "(" + exp.getLeft().accept(this.makePrettyp()) + "+" + exp.getRight().accept(this.makePrettyp()) + ")";
    }
    public String visit(Sub exp) {
        return "(" + exp.getLeft().accept(this.makePrettyp()) + "-" + exp.getRight().accept(this.makePrettyp()) + ")";
    }
    public String visit(Mult exp) {
        return "(" + exp.getLeft().accept(this.makePrettyp()) + "*" + exp.getRight().accept(this.makePrettyp()) + ")";
    }
    public String visit(Neg exp) {
        return "(-" + exp.getInner().accept(this.makePrettyp()) + ")";
    }
    public String visit(Divd exp) {
        return "(" + exp.getLeft().accept(this.makePrettyp()) + "/" + exp.getRight().accept(this.makePrettyp()) + ")";
    }

    public PrettypDivdMultNegTruncate makePrettyp() {
        return new PrettypDivdMultNegTruncate();
    }
}
