package ev.ep;

public class Prettyp implements VisitorSub<String> {

    public Prettyp() {
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

    public ev.ep.Prettyp makePrettyp() {
        return new ev.ep.Prettyp();
    }
}
