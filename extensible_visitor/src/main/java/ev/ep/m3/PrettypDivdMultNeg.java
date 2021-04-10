package ev.ep.m3;

import ev.ep.m2.Prettyp;

public class PrettypDivdMultNeg extends Prettyp implements VisitorDivdMultNeg<String> {

    public PrettypDivdMultNeg() {
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

    public PrettypDivdMultNeg makePrettyp() {
        return new PrettypDivdMultNeg();
    }
}
