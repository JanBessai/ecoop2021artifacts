package ev.ep.m4;

import ev.ep.Exp;
import ev.ep.Visitor;

public class Divd extends ev.ep.m3.Divd {

    public Divd(Exp _left, Exp _right) {
        super(_left, _right);
    }

    public void setLeft(Exp _left) {
        this.left = _left;
    }

    public void setRight(Exp _right) {
        this.right = _right;
    }

    public <R> R accept(Visitor<R> v) {
        return ((VisitorDivdMultNegTruncate<R>) v).visit(this);
    }
}
