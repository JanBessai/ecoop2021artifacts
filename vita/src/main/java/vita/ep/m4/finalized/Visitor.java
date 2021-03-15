package vita.ep.m4.finalized;

import vita.ep.m4.Exp;

public class Visitor {

    protected Exp<vita.ep.m4.finalized.Visitor> result;

    public Exp<vita.ep.m4.finalized.Visitor> getResult() {
        return result;
    }

    public void visit(Exp<vita.ep.m4.finalized.Visitor> visited) {
        this.result = visited;
    }
}
