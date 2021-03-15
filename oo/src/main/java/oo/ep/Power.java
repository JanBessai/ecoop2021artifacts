package oo.ep;

import java.util.List;
import util.Node;
import util.Tree;

public class Power extends Exp {

    protected Exp left;

    protected Exp right;

    public Power(Exp _left, Exp _right) {
        this.left = _left;
        this.right = _right;
    }

    public String prettyp() {
        return "(" + this.left.prettyp() + "^" + this.right.prettyp() + ")";
    }

    public Exp simplify() {
        if (Double.valueOf(this.right.eval()).equals(0.0)) {
            return new Lit(1.0);
        } else if (Double.valueOf(this.left.eval()).equals(1.0)) {
            return new Lit(1.0);
        } else {
            return new oo.ep.Power(this.left.simplify(), this.right.simplify());
        }
    }

    public List<Double> collect() {
        return java.util.stream.Stream.concat(this.left.collect().stream(), this.right.collect().stream()).collect(java.util.stream.Collectors.toList());
    }

    public Tree astree() {
        return new Node(this.id(), this.left.astree(), this.right.astree());
    }

    public Integer id() {
        return 77306085;
    }

    public Boolean equals(Exp other) {
        return this.astree().equals(other.astree());
    }

    public Exp multby(Exp other) {
        return new oo.ep.Power(this.left, new Add(this.right, new Lit(Math.log(2.718281828459045) / Math.log(this.right.eval()) / Math.log(2.718281828459045) / Math.log(this.left.eval()))));
    }

    public Exp powby(Exp other) {
        return new oo.ep.Power(this, other);
    }

    public Double eval() {
        return Math.pow(this.left.eval(), this.right.eval());
    }
}
