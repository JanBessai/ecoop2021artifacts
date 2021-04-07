package interpreter.ep.m0;

public class EvalLit implements EvalExp {

    public EvalLit(Double value) {
        this.value = value;
    }

    public Double getValue() {
        return this.value;
    }

    protected Double value;

    public Double eval() {
        return getValue();
    }
}
