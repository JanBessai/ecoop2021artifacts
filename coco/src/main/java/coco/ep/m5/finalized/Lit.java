package coco.ep.m5.finalized;

public class Lit extends Exp implements coco.ep.m5.Lit<Exp> {

    protected double value;

    public Lit(double _value) {
        this.value = _value;
    }

    public Double getValue() {
        return value;
    }
}
