package ev.ep.m7i2;

import ev.ep.Exp;
import ev.ep.Visitor;
import ev.ep.i2.VisitorPower;

public class Power extends ev.ep.i2.Power implements EqlQuery {

    public Power(Exp _left, Exp _right) { super(_left, _right); }

    public void setLeft(Exp _left) { this.left = _left; }
    public void setRight(Exp right) { this.right = right; }

    public Boolean isPower(ev.ep.m7i2.EqlQuery left, ev.ep.m7i2.EqlQuery right) {
        return ((Exp)left).accept(new EqlPower(getLeft())) && ((Exp)right).accept(new EqlPower(getRight()));
    }
    public <R> R accept(Visitor<R> v) {
        return ((VisitorPower<R>) v).visit(this);
    }
}

