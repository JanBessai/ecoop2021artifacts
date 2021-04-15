package interpreter.ep.m4;

import interpreter.ep.m2.PrettypLit;

public class CollectSimplifyLit extends PrettypLit implements CollectSimplifyExp {

    public CollectSimplifyLit(Double value) {
        super(value);
    }

    public void truncate (int level) { }
    
    public Double getValue() {
        return this.value;
    }

    public CollectSimplifyExp simplify() { return this; }

    public java.util.List<Double> collect() {
        java.util.List<Double> tmpList6 = new java.util.ArrayList<>();
        tmpList6.add(getValue());
        return tmpList6;
    }

}
