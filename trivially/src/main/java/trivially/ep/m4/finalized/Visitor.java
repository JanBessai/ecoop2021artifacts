package trivially.ep.m4.finalized;

import trivially.ep.m4.Exp;

public class Visitor {

    protected Exp<trivially.ep.m4.finalized.Visitor> result;

    public Exp<trivially.ep.m4.finalized.Visitor> getResult() {
        return result;
    }

    public void visit(Exp<trivially.ep.m4.finalized.Visitor> visited) {
        this.result = visited;
    }
}
