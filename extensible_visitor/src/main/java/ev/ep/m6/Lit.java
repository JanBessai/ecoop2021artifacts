package ev.ep.m6;

import ev.ep.Visitor;
import ev.ep.m4.VisitorDivdMultNegTruncate;

public class Lit extends ev.ep.m4.Lit implements EqlQuery {

    public Boolean isLit(Double d) { return d.equals(getValue()); }

    public Lit(double _value) {
        super(_value); }

    public <R> R accept(Visitor<R> v) {
        return ((VisitorDivdMultNegTruncate<R>) v).visit(this);
    }
}
