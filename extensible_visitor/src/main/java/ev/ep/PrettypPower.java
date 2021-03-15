package ev.ep;

public class PrettypPower implements VisitorPower<String> {

    public PrettypPower() {
    }

    public String visit(Power exp) {
        return "(" + exp.getLeft().<String>accept(this.makePrettyp()) + "^" + exp.getRight().<String>accept(this.makePrettyp()) + ")";
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

    public ev.ep.PrettypPower makePrettyp() {
        return new ev.ep.PrettypPower();
    }
}
