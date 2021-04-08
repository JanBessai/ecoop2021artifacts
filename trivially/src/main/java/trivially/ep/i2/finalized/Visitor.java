package trivially.ep.i2.finalized;

import trivially.ep.i2.Exp;

public class Visitor {

    protected Exp<Visitor> result;

    public Exp<Visitor> getResult() {
        return result;
    }

    public void visit(Exp<Visitor> visited) {
        this.result = visited;
    }
}
