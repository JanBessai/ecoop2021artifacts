package ev.ep.m0;

import ev.ep.Exp;
import ev.ep.Visitor;

public class Lit extends Exp {

    protected double value;

    public Lit(double _value) {
        this.value = _value;
    }

    public Double getValue() {
        return this.value;
    }
    public void setValue(Double d) { this.value = d; }

    public <R> R accept(Visitor<R> v) {
        return v.visit(this);
    }
}
