package oo.ep;

import java.util.List;
import util.Leaf;
import util.Node;
import util.Tree;

public class Lit extends Exp {

    protected double value;

    public Lit(double _value) {
        this.value = _value;
    }

    public String prettyp() {
        return String.valueOf(this.value);
    }

    public Exp simplify() {
        return this;
    }

    public List<Double> collect() {
        return java.util.Arrays.asList(this.value);
    }

    public void truncate (int level) {
        // do nothing
    }

    public Tree astree() {
        return new Node(this.id(), new Leaf<>(this.value));
    }

    public Integer id() {
        return 76407;
    }

    public Boolean equals(Exp other) {
        return this.astree().equals(other.astree());
    }

    public Boolean isLit(Double d) {
        return d.equals(value);
    }

    public Boolean eql(Exp that) {
        return that.isLit(value);
    }

    // ORIGINAL implementation for multby before merge
    public Exp multby_old(Exp other) {
        Exp result = other;
        double counter = Math.floor(Math.abs(this.value));
        while (1.0 < counter) {
            result = new Add(result, other);
            counter = counter - 1.0;
        }
        if (this.value < 0.0) {
            result = new Sub(new oo.ep.Lit(0.0), result);
        }
        return result;
    }

    public Exp multby(Exp other) {
        return new Mult(this, other);
    }

    // ORIGINAL implementation for powby before merge
    public Exp powby_old(Exp other) {
        Double exponentValue = other.eval();
        Exp result = this;
        double counter = Math.floor(Math.abs(exponentValue));
        while (1.0 < counter) {
            result = new Mult(result, this);
            counter = counter - 1.0;
        }
        if (this.value < 0.0) {
            result = new Divd(new oo.ep.Lit(1.0), result);
        }
        return result;
    }

    public Exp powby(Exp other) {
        return new Power(this, other);
    }

    public Double eval() {
        return this.value;
    }
}
