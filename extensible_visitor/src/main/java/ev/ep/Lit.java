package ev.ep;

public class Lit extends Exp {

    protected double value;

    public Lit(double _value) {
        this.value = _value;
    }

    public Double getValue() {
        return this.value;
    }

    public <R> R accept(Visitor<R> v) {
        return ((Visitor<R>) v).visit(this);
    }
}
