package vita.ep.m1.finalized;

import vita.ep.m1.Exp;

public class Visitor {

    protected Exp<vita.ep.m1.finalized.Visitor> result;

    public Exp<vita.ep.m1.finalized.Visitor> getResult() {
        return result;
    }

    public void visit(Exp<vita.ep.m1.finalized.Visitor> visited) {
        this.result = visited;
    }
}
