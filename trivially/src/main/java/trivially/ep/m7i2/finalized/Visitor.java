package trivially.ep.m7i2.finalized;

import trivially.ep.m7i2.Exp;

public class Visitor {

    protected Exp<trivially.ep.m7i2.finalized.Visitor> result;

    public Exp<trivially.ep.m7i2.finalized.Visitor> getResult() {
        return result;
    }

    public void visit(Exp<trivially.ep.m7i2.finalized.Visitor> visited) {
        this.result = visited;
    }
}
