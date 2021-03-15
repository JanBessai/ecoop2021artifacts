package vita.ep.m6.finalized;

import vita.ep.m6.Exp;

public class Visitor {

    protected Exp<vita.ep.m6.finalized.Visitor> result;

    public Exp<vita.ep.m6.finalized.Visitor> getResult() {
        return result;
    }

    public void visit(Exp<vita.ep.m6.finalized.Visitor> visited) {
        this.result = visited;
    }
}
