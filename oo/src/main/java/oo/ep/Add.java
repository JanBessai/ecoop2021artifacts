package oo.ep;

import java.util.List;
import util.Node;
import util.Tree;

public class Add extends Exp {

    protected Exp left;
    protected Exp right;

    public Add(Exp _left, Exp _right) {
        this.left = _left;
        this.right = _right;
    }

    public String prettyp() {
        return "(" + this.left.prettyp() + "+" + this.right.prettyp() + ")";
    }

    public Exp simplify() {
        if (Double.valueOf(this.left.eval() + this.right.eval()).equals(0.0)) {
            return new Lit(0.0);
        } else if (this.left.eval().equals(0.0)) {
            return this.right.simplify();
        } else if (this.right.eval().equals(0.0)) {
            return this.left.simplify();
        } else {
            return new oo.ep.Add(this.left.simplify(), this.right.simplify());
        }
    }

    public List<Double> collect() {
        return java.util.stream.Stream.concat(this.left.collect().stream(), this.right.collect().stream()).collect(java.util.stream.Collectors.toList());
    }

    public void truncate (int level) {
        if (level > 1) {
            left.truncate(level-1);
            right.truncate(level-1);
        } else {
            left = new Lit(left.eval());
            right = new Lit(right.eval());
        }
    }

    public Tree astree() {
        return new Node(this.id(), this.left.astree(), this.right.astree());
    }

    public Integer id() {
        return 65665;
    }

    public Boolean equals(Exp other) {
        return this.astree().equals(other.astree());
    }

    public Boolean isAdd(Exp left, Exp right) {
        return left.eql(this.left) && right.eql(this.right);
    }

    public Boolean eql(Exp that) {
        return that.isAdd(this.left, this.right);
    }

    public Exp multby(Exp other) { return new Mult(this, other); }
    public Exp powby(Exp other) { return new Power(this, other); }

    public Double eval() {
        return this.left.eval() + this.right.eval();
    }
}
