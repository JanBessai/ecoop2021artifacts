package trivially.ep.m6.finalized;

import trivially.ep.m6.Exp;

public class Visitor {

    protected Exp<trivially.ep.m6.finalized.Visitor> result;

    public Exp<trivially.ep.m6.finalized.Visitor> getResult() {
        return result;
    }

    public void visit(Exp<trivially.ep.m6.finalized.Visitor> visited) {
        this.result = visited;
    }
}
