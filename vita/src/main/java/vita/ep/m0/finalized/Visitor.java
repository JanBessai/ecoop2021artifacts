package vita.ep.m0.finalized;

import vita.ep.m0.Exp;

public class Visitor {

    protected Exp<vita.ep.m0.finalized.Visitor> result;

    public Exp<vita.ep.m0.finalized.Visitor> getResult() {
        return result;
    }

    public void visit(Exp<vita.ep.m0.finalized.Visitor> visited) {
        this.result = visited;
    }
}
