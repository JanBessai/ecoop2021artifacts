package oo.ep;

import java.util.List;
import util.Node;
import util.Tree;

public class Mult extends Exp {

    protected Exp left;

    protected Exp right;

    public Mult(Exp _left, Exp _right) {
        this.left = _left;
        this.right = _right;
    }

    public String prettyp() {
        return "(" + this.left.prettyp() + "*" + this.right.prettyp() + ")";
    }

    public Exp simplify() {
        if (this.left.eval().equals(0.0) || this.right.eval().equals(0.0)) {
            return new Lit(0.0);
        } else if (this.left.eval().equals(1.0)) {
            return this.right.simplify();
        } else if (this.right.eval().equals(1.0)) {
            return this.left.simplify();
        } else {
            return new oo.ep.Mult(this.left.simplify(), this.right.simplify());
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
        return 2409808;
    }

    public Boolean equals(Exp other) {
        return this.astree().equals(other.astree());
    }

    public Boolean isMult(Exp left, Exp right) {
        return left.eql(this.left) && right.eql(this.right);
    }

    public Boolean eql(Exp that) {
        return that.isMult(this.left, this.right);
    }

    public Exp multby(Exp other) {
        return new oo.ep.Mult(this, other);
    }

    public Exp powby(Exp other) {
        return new oo.ep.Mult(this.left.powby(other), this.right.powby(other));
    }

    public Double eval() {
        return this.left.eval() * this.right.eval();
    }
}
