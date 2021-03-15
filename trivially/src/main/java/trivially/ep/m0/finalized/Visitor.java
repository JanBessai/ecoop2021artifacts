package trivially.ep.m0.finalized;

import trivially.ep.m0.Exp;

public class Visitor {

    protected Exp<trivially.ep.m0.finalized.Visitor> result;

    public Exp<trivially.ep.m0.finalized.Visitor> getResult() {
        return result;
    }

    public void visit(Exp<trivially.ep.m0.finalized.Visitor> visited) {
        this.result = visited;
    }
}
