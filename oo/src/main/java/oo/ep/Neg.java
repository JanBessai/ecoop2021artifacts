package oo.ep;

import java.util.List;
import util.Node;
import util.Tree;

public class Neg extends Exp {

    protected Exp inner;

    public Neg(Exp _inner) {
        this.inner = _inner;
    }

    public String prettyp() {
        return "(-" + this.inner.prettyp() + ")";
    }

    public Exp simplify() {
        if (this.inner.eval().equals(0.0)) {
            return new Lit(0.0);
        } else {
            return new oo.ep.Neg(this.inner.simplify());
        }
    }

    public List<Double> collect() {
        return this.inner.collect();
    }

    public void truncate (int level) {
        if (level > 1) {
            inner.truncate(level-1);
        } else {
            inner = new Lit(inner.eval());
        }
    }

    public Tree astree() {
        return new Node(this.id(), this.inner.astree());
    }

    public Integer id() {
        return 78192;
    }

    public Boolean equals(Exp other) {
        return this.astree().equals(other.astree());
    }

    public Boolean isNeg(Exp inner) {
        return inner.eql(this.inner);
    }

    public Boolean eql(Exp that) {
        return that.isNeg(this.inner);
    }

    // simplified because of merge
    public Exp multby(Exp other) {
        return new Mult(this, other);
    }

    // simplified because of merge
    public Exp powby(Exp other) { return new Power(this, other); }

    public Double eval() {
        return -1.0 * this.inner.eval();
    }
}
