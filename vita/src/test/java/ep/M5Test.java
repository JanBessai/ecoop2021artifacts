package vita.ep;

import vita.ep.m5.Exp;
import vita.ep.m5.finalized.Add;
import vita.ep.m5.finalized.Divd;
import vita.ep.m5.finalized.Lit;
import vita.ep.m5.finalized.Mult;
import vita.ep.m5.finalized.Neg;
import vita.ep.m5.finalized.Sub;
import org.combinators.vita.ep.util.Leaf;
import org.combinators.vita.ep.util.Node;
import org.junit.Test;

public class M5Test {

    @Test
    public void testTest() {
        org.junit.Assert.assertTrue("", this.sub(this.neg(this.lit(2.0)), this.mult(this.sub(this.lit(1.0), this.lit(976.0)), this.add(this.mult(this.lit(1.0), this.lit(976.0)), this.divd(this.lit(1.0), this.lit(3.0))))).astree().equals(new Node(83488, new Node(78192, new Node(76407, new Leaf<Double>(2.0))), new Node(2409808, new Node(83488, new Node(76407, new Leaf<Double>(1.0)), new Node(76407, new Leaf<Double>(976.0))), new Node(65665, new Node(2409808, new Node(76407, new Leaf<Double>(1.0)), new Node(76407, new Leaf<Double>(976.0))), new Node(2130451, new Node(76407, new Leaf<Double>(1.0)), new Node(76407, new Leaf<Double>(3.0))))))));
        org.junit.Assert.assertTrue("", this.sub(this.neg(this.lit(2.0)), this.mult(this.sub(this.lit(1.0), this.lit(976.0)), this.add(this.mult(this.lit(1.0), this.lit(976.0)), this.divd(this.lit(1.0), this.lit(3.0))))).prettyp().equals("(-2.0-((1.0-976.0)*((1.0*976.0)+(1.0/3.0))))"));
        org.junit.Assert.assertTrue("", this.mult(this.mult(this.lit(2.0), this.lit(1.0)), this.add(this.lit(0.0), this.lit(7.0))).simplify().astree().equals(new Node(2409808, new Node(76407, new Leaf<Double>(2.0)), new Node(76407, new Leaf<Double>(7.0)))));
    }

    public Sub sub(Exp<vita.ep.m5.finalized.Visitor> left, Exp<vita.ep.m5.finalized.Visitor> right) {
        return new Sub(left, right);
    }

    public Neg neg(Exp<vita.ep.m5.finalized.Visitor> inner) {
        return new Neg(inner);
    }

    public Mult mult(Exp<vita.ep.m5.finalized.Visitor> left, Exp<vita.ep.m5.finalized.Visitor> right) {
        return new Mult(left, right);
    }

    public Divd divd(Exp<vita.ep.m5.finalized.Visitor> left, Exp<vita.ep.m5.finalized.Visitor> right) {
        return new Divd(left, right);
    }

    public Lit lit(Double value) {
        return new Lit(value);
    }

    public Add add(Exp<vita.ep.m5.finalized.Visitor> left, Exp<vita.ep.m5.finalized.Visitor> right) {
        return new Add(left, right);
    }
}
