package interpreter.ep.m5;

import interpreter.ep.m4.CollectSimplifyLit;

public class AstreeIdzLit extends CollectSimplifyLit implements AstreeIdzExp {

    public AstreeIdzLit(Double value) {
        super(value);
    }

    public util.Tree astree() {
        return new util.Node(idz(), new util.Leaf<>(getValue()));
    }

    public AstreeIdzExp simplify() { return this; }

    public Integer idz() {
        return 76407;
    }
}
