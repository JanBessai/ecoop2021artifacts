package vita.ep.m3.finalized;

import vita.ep.m3.Exp;

public class Visitor {

    protected Exp<vita.ep.m3.finalized.Visitor> result;

    public Exp<vita.ep.m3.finalized.Visitor> getResult() {
        return result;
    }

    public void visit(Exp<vita.ep.m3.finalized.Visitor> visited) {
        this.result = visited;
    }
}
