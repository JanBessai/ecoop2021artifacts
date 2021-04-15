package interpreter.ep.m0;

public class EvalLit implements EvalExp {

    public EvalLit(Double value) {
        this.value = value;
    }

    protected Double value;

    public Double eval() {
        return value;
    }
}
