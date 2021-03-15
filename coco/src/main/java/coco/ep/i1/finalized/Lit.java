package coco.ep.i1.finalized;

public class Lit extends Exp implements coco.ep.i1.Lit<Exp> {

    protected double value;

    public Lit(double _value) {
        this.value = _value;
    }

    public Double getValue() {
        return this.value;
    }
}
