package ev.ep.m7i2;

import ev.ep.i2.Power;
import ev.ep.m0.Add;
import ev.ep.m0.Lit;

public class PrettypPower implements VisitorMerged<String> {

    public PrettypPower() {
    }

    String visitAdd(String left, String right) {
        return "(" + left + "+" + right + ")";
    }
    String visitSub(String left, String right) {
        return "(" + left + "-" + right + ")";
    }
    String visitMult(String left, String right) {
        return "(" + left + "*" + right + ")";
    }
    String visitDivd(String left, String right) {
        return "(" + left + "/" + right + ")";
    }
    String visitNeg(String inner) {
        return "(-" + inner + ")";
    }
    String visitPower(String left, String right) {
        return "(" + left + "^" + right + ")";
    }

    public String visit(ev.ep.m7i2.Power exp) { return visitPower(exp.getLeft().accept(makePrettyp()), exp.getRight().accept(makePrettyp())); }
    public String visit(ev.ep.i2.Power exp) { return visitPower(exp.getLeft().accept(makePrettyp()), exp.getRight().accept(makePrettyp())); }

    public String visit(ev.ep.m7i2.Neg exp) { return visitNeg(exp.getInner().accept(makePrettyp())); }
    public String visit(ev.ep.m4.Neg exp) { return visitNeg(exp.getInner().accept(makePrettyp())); }
    public String visit(ev.ep.m3.Neg exp) { return visitNeg(exp.getInner().accept(makePrettyp())); }

    public String visit(ev.ep.m7i2.Mult exp) { return visitMult(exp.getLeft().accept(makePrettyp()), exp.getRight().accept(makePrettyp())); }
    public String visit(ev.ep.m4.Mult exp) { return visitMult(exp.getLeft().accept(makePrettyp()), exp.getRight().accept(makePrettyp())); }
    public String visit(ev.ep.m3.Mult exp) { return visitMult(exp.getLeft().accept(makePrettyp()), exp.getRight().accept(makePrettyp())); }

    public String visit(ev.ep.m7i2.Divd exp) { return visitDivd(exp.getLeft().accept(makePrettyp()), exp.getRight().accept(makePrettyp())); }
    public String visit(ev.ep.m4.Divd exp) { return visitDivd(exp.getLeft().accept(makePrettyp()), exp.getRight().accept(makePrettyp())); }
    public String visit(ev.ep.m3.Divd exp) { return visitDivd(exp.getLeft().accept(makePrettyp()), exp.getRight().accept(makePrettyp())); }

    public String visit(ev.ep.m7i2.Sub exp) { return visitSub(exp.getLeft().accept(makePrettyp()), exp.getRight().accept(makePrettyp())); }
    public String visit(ev.ep.m4.Sub exp) { return visitSub(exp.getLeft().accept(makePrettyp()), exp.getRight().accept(makePrettyp())); }
    public String visit(ev.ep.m1.Sub exp) { return visitSub(exp.getLeft().accept(makePrettyp()), exp.getRight().accept(makePrettyp())); }

    public String visit(ev.ep.m7i2.Lit exp) { return String.valueOf(exp.getValue()); }
    public String visit(ev.ep.m4.Lit exp) { return String.valueOf(exp.getValue()); }
    public String visit(ev.ep.m0.Lit exp) { return String.valueOf(exp.getValue()); }

    public String visit(ev.ep.m7i2.Add exp) { return visitAdd(exp.getLeft().accept(makePrettyp()), exp.getRight().accept(makePrettyp())); }
    public String visit(ev.ep.m4.Add exp) { return visitAdd(exp.getLeft().accept(makePrettyp()), exp.getRight().accept(makePrettyp())); }
    public String visit(ev.ep.m0.Add exp) { return visitAdd(exp.getLeft().accept(makePrettyp()), exp.getRight().accept(makePrettyp())); }

    public PrettypPower makePrettyp() { return new PrettypPower();  }
}
