package ev.ep;

public class PrettypDivdMultNeg extends Prettyp implements VisitorDivdMultNeg<String> {

    public PrettypDivdMultNeg() {
    }

    public String visit(Neg exp) {
        return "-" + exp.getInner().<String>accept(this.makePrettyp());
    }

    public String visit(Mult exp) {
        return "(" + exp.getLeft().<String>accept(this.makePrettyp()) + "*" + exp.getRight().<String>accept(this.makePrettyp()) + ")";
    }

    public String visit(Divd exp) {
        return "(" + exp.getLeft().<String>accept(this.makePrettyp()) + "/" + exp.getRight().<String>accept(this.makePrettyp()) + ")";
    }

    public String visit(Sub exp) {
        return "(" + exp.getLeft().<String>accept(this.makePrettyp()) + "-" + exp.getRight().<String>accept(this.makePrettyp()) + ")";
    }

    public String visit(Lit exp) {
        return String.valueOf(exp.getValue());
    }

    public String visit(Add exp) {
        return "(" + exp.getLeft().<String>accept(this.makePrettyp()) + "+" + exp.getRight().<String>accept(this.makePrettyp()) + ")";
    }

    public ev.ep.PrettypDivdMultNeg makePrettyp() {
        return new ev.ep.PrettypDivdMultNeg();
    }
}
