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

    public Tree astree() {
        return new Node(this.id(), new Leaf<Double>(this.value));
    }

    public Integer id() {
        return 76407;
    }

    public Boolean equals(Exp other) {
        return this.astree().equals(other.astree());
    }

    public Exp multby(Exp other) {
        Exp result = other;
        Double counter = Math.floor(Math.abs(this.value));
        while (1.0 < counter) {
            result = new Add(result, other);
            counter = counter - 1.0;
        }
        if (this.value < 0.0) {
            result = new Sub(new oo.ep.Lit(0.0), result);
        }
        return result;
    }

    public Exp powby(Exp other) {
        Double exponentValue = other.eval();
        Exp result = this;
        Double counter = Math.floor(Math.abs(exponentValue));
        while (1.0 < counter) {
            result = new Mult(result, this);
            counter = counter - 1.0;
        }
        if (this.value < 0.0) {
            result = new Divd(new oo.ep.Lit(1.0), result);
        }
        return result;
    }

    public Double eval() {
        return this.value;
    }
}
