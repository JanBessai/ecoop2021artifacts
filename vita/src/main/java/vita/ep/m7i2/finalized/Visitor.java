package vita.ep.m7i2.finalized;

import vita.ep.m7i2.Exp;

public class Visitor {

    protected Exp<vita.ep.m7i2.finalized.Visitor> result;

    public Exp<vita.ep.m7i2.finalized.Visitor> getResult() {
        return result;
    }

    public void visit(Exp<vita.ep.m7i2.finalized.Visitor> visited) {
        this.result = visited;
    }
}
