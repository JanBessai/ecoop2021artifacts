package ev.ep.m7i2;

import ev.ep.i2.VisitorPower;
import ev.ep.i2.Power;
import ev.ep.m0.Add;
import ev.ep.m0.Lit;
import ev.ep.m1.Sub;
import ev.ep.m3.Divd;
import ev.ep.m3.Mult;
import ev.ep.m3.Neg;
import util.Leaf;
import util.Node;
import util.Tree;

public class AstreePower implements VisitorPower<Tree> {

    public AstreePower() {
    }

    public Tree visit(Power exp) {
        return new Node(exp.<Integer>accept(this.makeId()), exp.getLeft().accept(this.makeAstree()), exp.getRight().accept(this.makeAstree()));
    }

    public Tree visit(Neg exp) {
        return new Node(exp.<Integer>accept(this.makeId()), exp.getInner().accept(this.makeAstree()));
    }

    public Tree visit(Mult exp) {
        return new Node(exp.<Integer>accept(this.makeId()), exp.getLeft().accept(this.makeAstree()), exp.getRight().accept(this.makeAstree()));
    }

    public Tree visit(Divd exp) {
        return new Node(exp.<Integer>accept(this.makeId()), exp.getLeft().accept(this.makeAstree()), exp.getRight().accept(this.makeAstree()));
    }

    public Tree visit(Sub exp) {
        return new Node(exp.<Integer>accept(this.makeId()), exp.getLeft().accept(this.makeAstree()), exp.getRight().accept(this.makeAstree()));
    }

    public Tree visit(Lit exp) {
        return new Node(exp.<Integer>accept(this.makeId()), new Leaf<>(exp.getValue()));
    }

    public Tree visit(Add exp) {
        return new Node(exp.<Integer>accept(this.makeId()), exp.getLeft().accept(this.makeAstree()), exp.getRight().accept(this.makeAstree()));
    }

    public IdPower makeId() {
        return new IdPower();
    }

    public AstreePower makeAstree() {
        return new AstreePower();
    }
}
