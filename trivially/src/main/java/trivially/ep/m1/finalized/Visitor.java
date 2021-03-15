package trivially.ep.m1.finalized;

import trivially.ep.m1.Exp;

public class Visitor {

    protected Exp<trivially.ep.m1.finalized.Visitor> result;

    public Exp<trivially.ep.m1.finalized.Visitor> getResult() {
        return result;
    }

    public void visit(Exp<trivially.ep.m1.finalized.Visitor> visited) {
        this.result = visited;
    }
}
