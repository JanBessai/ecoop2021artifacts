package oo.ep;

import java.util.List;
import util.Node;
import util.Tree;

public class Sub extends Exp {

    protected Exp left;

    protected Exp right;

    public Sub(Exp _left, Exp _right) {
        this.left = _left;
        this.right = _right;
    }

    public String prettyp() {
        return "(" + this.left.prettyp() + "-" + this.right.prettyp() + ")";
    }

    public Exp simplify() {
        if (Double.valueOf(this.left.eval()).equals(this.right.eval())) {
            return new Lit(0.0);
        } else {
            return new oo.ep.Sub(this.left.simplify(), this.right.simplify());
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
        return 83488;
    }

    public Boolean equals(Exp other) {
        return this.astree().equals(other.astree());
    }

    public Boolean isSub(Exp left, Exp right) {
        return left.eql(this.left) && right.eql(this.right);
    }

    public Boolean eql(Exp that) {
        return that.isSub(this.left, this.right);
    }

    public Exp multby(Exp other) {
        return new oo.ep.Sub(this.left.multby(other), this.right.multby(other));
    }

    public Exp powby(Exp other) {
        return new Lit(this.eval()).powby(other);
    }

    public Double eval() {
        return this.left.eval() - this.right.eval();
    }
}
