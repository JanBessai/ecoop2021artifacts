package coco.ep.m7i2;

import coco.ep.Exp;
import util.Node;
import util.Tree;

import java.util.List;

public interface Power<FT> extends coco.ep.i2.Power<FT>, coco.ep.m7i2.Exp<FT>, Factory<FT> {
	void setLeft(coco.ep.Exp<FT> left);
	void setRight(coco.ep.Exp<FT> right);

    default coco.ep.Exp<FT> multby(coco.ep.Exp<FT> other) {return this.mult(this, convert(other)); }
    default coco.ep.Exp<FT> powby(coco.ep.Exp<FT> other) {
        return this.power(this, convert(other));
    }

    default void truncate (int level) {
		if (level > 1) {
			convert(getLeft()).truncate(level-1);
			convert(getRight()).truncate(level-1);
		} else {
			setLeft(this.lit(convert(getLeft()).eval()));
			setRight(this.lit(convert(getRight()).eval()));
		}
	}
	
    default Exp<FT> simplify() {
        if (convert(getRight()).eval().equals(0.0)) {
            return this.lit(1.0);
        } else if (convert(getLeft()).eval().equals(1.0)) {
            return this.lit(1.0);
        } else if (convert(getRight()).eval().equals(1.0)) {
            return convert(getLeft()).simplify();
        } else {
            return this.power(convert(getLeft()).simplify(), convert(getRight()).simplify());
        }
    }

    default List<Double> collect() {
        return java.util.stream.Stream.concat(convert(getLeft()).collect().stream(), convert(getRight()).collect().stream()).collect(java.util.stream.Collectors.toList());
    }

    default Tree astree() {
        return new Node(convert(this).id(), convert(getLeft()).astree(), convert(getRight()).astree());
    }

    default Integer id() {
        return 77306085;
    }

    default Boolean equals(Exp<FT> other) {
        return convert(this).astree().equals(convert(other).astree());
    }

    default Boolean isPower(coco.ep.Exp<FT> left, coco.ep.Exp<FT> right) {
        return convert(left).eql(getLeft()) && convert(right).eql(getRight());
    }

    default Boolean eql(coco.ep.Exp<FT> that) {
	    return convert(that).isPower(convert(getLeft()), convert(getRight()));
    }
}
