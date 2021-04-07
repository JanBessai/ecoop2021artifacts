package interpreter.ep.m5;

import interpreter.ep.m4.CollectSimplifyMult;

public class AstreeIdzMult extends CollectSimplifyMult implements AstreeIdzExp {

    public AstreeIdzMult(AstreeIdzExp left, AstreeIdzExp right) {
        super(left, right);
    }

    public AstreeIdzExp getLeft() {
        return (AstreeIdzExp) this.left;
    }

    public AstreeIdzExp getRight() {
        return (AstreeIdzExp) this.right;
    }

    public util.Tree astree() {
        return new util.Node(this.idz(), getLeft().astree(), getRight().astree());
    }

    public Integer idz() {
        return 2409808;
    }
}
