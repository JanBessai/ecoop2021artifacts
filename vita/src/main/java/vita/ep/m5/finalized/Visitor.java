package vita.ep.m5.finalized;

import vita.ep.m5.Exp;

public class Visitor {

    protected Exp<vita.ep.m5.finalized.Visitor> result;

    public Exp<vita.ep.m5.finalized.Visitor> getResult() {
        return result;
    }

    public void visit(Exp<vita.ep.m5.finalized.Visitor> visited) {
        this.result = visited;
    }
}
