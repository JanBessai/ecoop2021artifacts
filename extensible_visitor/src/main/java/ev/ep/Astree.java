package ev.ep;

import util.Leaf;
import util.Node;
import util.Tree;

public class Astree implements VisitorDivdMultNeg<Tree> {

    public Astree() {
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

    public Id makeId() {
        return new Id();
    }

    public ev.ep.Astree makeAstree() {
        return new ev.ep.Astree();
    }
}
