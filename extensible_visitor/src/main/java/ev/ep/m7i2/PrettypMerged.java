package ev.ep.m7i2;

import ev.ep.m3.PrettypDivdMultNeg;

public class PrettypMerged extends PrettypDivdMultNeg implements VisitorMerged<String> {

    public PrettypMerged() { }

    public String visit(ev.ep.i2.Power exp) {
        return "(" + exp.getLeft().accept(this) + "^" + exp.getRight().accept(this) + ")";
    }
}
