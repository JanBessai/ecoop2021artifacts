package trivially.ep.m5.finalized;

import trivially.ep.m5.Exp;

public class Visitor {

    protected Exp<trivially.ep.m5.finalized.Visitor> result;

    public Exp<trivially.ep.m5.finalized.Visitor> getResult() {
        return result;
    }

    public void visit(Exp<trivially.ep.m5.finalized.Visitor> visited) {
        this.result = visited;
    }
}
