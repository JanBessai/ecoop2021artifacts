package trivially.ep.i1.finalized;

import trivially.ep.i1.Exp;

public class Visitor {

    protected Exp<Visitor> result;

    public Exp<Visitor> getResult() {
        return result;
    }

    public void visit(Exp<Visitor> visited) {
        this.result = visited;
    }
}
