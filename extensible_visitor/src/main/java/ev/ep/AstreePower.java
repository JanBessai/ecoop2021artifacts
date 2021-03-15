package ev.ep;

import util.Leaf;
import util.Node;
import util.Tree;

public class AstreePower implements VisitorPower<Tree> {

    public AstreePower() {
    }

    public Tree visit(Power exp) {
        return new Node(exp.<Integer>accept(this.makeId()), exp.getLeft().<Tree>accept(this.makeAstree()), exp.getRight().<Tree>accept(this.makeAstree()));
    }

    public Tree visit(Neg exp) {
        return new Node(exp.<Integer>accept(this.makeId()), exp.getInner().<Tree>accept(this.makeAstree()));
    }

    public Tree visit(Mult exp) {
        return new Node(exp.<Integer>accept(this.makeId()), exp.getLeft().<Tree>accept(this.makeAstree()), exp.getRight().<Tree>accept(this.makeAstree()));
    }

    public Tree visit(Divd exp) {
        return new Node(exp.<Integer>accept(this.makeId()), exp.getLeft().<Tree>accept(this.makeAstree()), exp.getRight().<Tree>accept(this.makeAstree()));
    }

    public Tree visit(Sub exp) {
        return new Node(exp.<Integer>accept(this.makeId()), exp.getLeft().<Tree>accept(this.makeAstree()), exp.getRight().<Tree>accept(this.makeAstree()));
    }

    public Tree visit(Lit exp) {
        return new Node(exp.<Integer>accept(this.makeId()), new Leaf<Double>(exp.getValue()));
    }

    public Tree visit(Add exp) {
        return new Node(exp.<Integer>accept(this.makeId()), exp.getLeft().<Tree>accept(this.makeAstree()), exp.getRight().<Tree>accept(this.makeAstree()));
    }

    public IdPower makeId() {
        return new IdPower();
    }

    public ev.ep.AstreePower makeAstree() {
        return new ev.ep.AstreePower();
    }
}
