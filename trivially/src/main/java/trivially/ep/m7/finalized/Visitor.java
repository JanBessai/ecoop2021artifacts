package trivially.ep.m7.finalized;

import trivially.ep.m7.Exp;

public class Visitor {

    protected Exp<trivially.ep.m7.finalized.Visitor> result;

    public Exp<trivially.ep.m7.finalized.Visitor> getResult() {
        return result;
    }

    public void visit(Exp<trivially.ep.m7.finalized.Visitor> visited) {
        this.result = visited;
    }
}
