package trivially.ep.m7i2;

import trivially.ep.m7i2.finalized.Add;
import trivially.ep.m7i2.finalized.Lit;
import java.util.List;
import util.Node;
import util.Tree;

public interface Power extends Exp, trivially.ep.i2.Power {

    Exp getLeft();

    Exp getRight();

    void setLeft(Exp left);
    void setRight(Exp right);

    default Tree astree() {
        return new Node(this.id(), this.getLeft().astree(), this.getRight().astree());
    }

    // unsafe casts
    default Exp powby(trivially.ep.m7.Exp other) { return new trivially.ep.m7i2.finalized.Power(this, (trivially.ep.m7i2.Exp)other); }
    default Exp multby(trivially.ep.i1.Exp other) { return  new trivially.ep.m7i2.finalized.Mult(this, (trivially.ep.m7i2.Exp)other); }

    default Boolean equals(trivially.ep.m6.Exp other) {
        return this.astree().equals(( other).astree());
    }

    default Boolean isPower(trivially.ep.m7i2.Exp left, trivially.ep.m7i2.Exp right) {
        return left.eql(getLeft()) && right.eql(getRight());
    }

    // Unsafe cast
    default Boolean eql(trivially.ep.m6.Exp that) { return ((trivially.ep.m7i2.Exp)that).isPower(getLeft(), getRight()); }

    default Integer id() {
        return 77306085;
    }

    default List<Double> collect() {
        return java.util.stream.Stream.concat(this.getLeft().collect().stream(), this.getRight().collect().stream()).collect(java.util.stream.Collectors.toList());
    }

    default Exp simplify() {
        if (this.getRight().eval().equals(0.0)) {
            return new Lit(1.0);
        } else if (this.getLeft().eval().equals(1.0)) {
            return new Lit(1.0);
        } else if (getRight().eval().equals(1.0)) {
            return getLeft().simplify();
        } else {
            return new trivially.ep.m7i2.finalized.Power(this.getLeft().simplify(), this.getRight().simplify());
        }
    }

    default void truncate (int level) {
        if (level > 1) {
            getLeft().truncate(level-1);
            getRight().truncate(level-1);
        } else {
            setLeft(new trivially.ep.m7i2.finalized.Lit(getLeft().eval()));
            setRight(new trivially.ep.m7i2.finalized.Lit(getRight().eval()));
        }
    }
}
