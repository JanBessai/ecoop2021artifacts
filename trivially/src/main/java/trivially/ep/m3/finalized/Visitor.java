package trivially.ep.m3.finalized;

import trivially.ep.m3.Exp;

public class Visitor {

    protected Exp<trivially.ep.m3.finalized.Visitor> result;

    public Exp<trivially.ep.m3.finalized.Visitor> getResult() {
        return result;
    }

    public void visit(Exp<trivially.ep.m3.finalized.Visitor> visited) {
        this.result = visited;
    }
}
