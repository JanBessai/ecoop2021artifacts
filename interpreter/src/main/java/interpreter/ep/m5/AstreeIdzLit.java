package interpreter.ep.m5;

import interpreter.ep.m4.CollectSimplifyLit;

public class AstreeIdzLit extends CollectSimplifyLit implements AstreeIdzExp {

    public AstreeIdzLit(Double value) {
        super(value);
    }

    public Double getValue() {
        return this.value;
    }

    public util.Tree astree() {
        return new util.Leaf(getValue());
    }

    public Integer idz() {
        return 76407;
    }

}
