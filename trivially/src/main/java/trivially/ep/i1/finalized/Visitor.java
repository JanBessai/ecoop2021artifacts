package trivially.ep.i1.finalized;

import trivially.ep.i1.Exp;

public class Visitor {

    protected Exp<trivially.ep.i1.finalized.Visitor> result;

    public Exp<trivially.ep.i1.finalized.Visitor> getResult() {
        return result;
    }

    public void visit(Exp<trivially.ep.i1.finalized.Visitor> visited) {
        this.result = visited;
    }
}
