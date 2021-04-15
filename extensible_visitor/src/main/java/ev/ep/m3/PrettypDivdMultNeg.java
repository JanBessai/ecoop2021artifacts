package ev.ep.m3;

import ev.ep.m2.Prettyp;

public class PrettypDivdMultNeg extends Prettyp implements VisitorDivdMultNeg<String> {

    public PrettypDivdMultNeg() { }

    public String visit(Neg exp) {
        return "(-" + exp.getInner().accept(this) + ")";
    }

    public String visit(Mult exp) {
        return "(" + exp.getLeft().accept(this) + "*" + exp.getRight().accept(this) + ")";
    }

    public String visit(Divd exp) {
        return "(" + exp.getLeft().accept(this) + "/" + exp.getRight().accept(this) + ")";
    }

}
