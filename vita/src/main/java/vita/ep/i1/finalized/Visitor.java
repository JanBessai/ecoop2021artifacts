package vita.ep.i1.finalized;

import vita.ep.i1.Exp;

public class Visitor {

    protected Exp<vita.ep.i1.finalized.Visitor> result;

    public Exp<vita.ep.i1.finalized.Visitor> getResult() {
        return result;
    }

    public void visit(Exp<vita.ep.i1.finalized.Visitor> visited) {
        this.result = visited;
    }
}
