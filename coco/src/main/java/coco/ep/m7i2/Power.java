package coco.ep.m7i2;

import coco.ep.Exp;
import util.Node;
import util.Tree;

import java.util.List;

public interface Power<FT> extends coco.ep.i2.Power<FT>, coco.ep.m7i2.Exp<FT>, Factory<FT> {
	void setLeft(coco.ep.Exp<FT> left);
	void setRight(coco.ep.Exp<FT> right);
	
	public default void truncate (int level) {
		if (level > 1) {
			this.convert(this.getLeft()).truncate(level-1);
			this.convert(this.getRight()).truncate(level-1);
		} else {
			setLeft(this.lit(this.convert(this.getLeft()).eval()));
			setRight(this.lit(this.convert(this.getRight()).eval()));
		}
	}
	
    public default Exp<FT> simplify() {
        if (Double.valueOf(this.convert(this.getRight()).eval()).equals(0.0)) {
            return this.lit(1.0);
        } else if (Double.valueOf(this.convert(this.getLeft()).eval()).equals(1.0)) {
            return this.lit(1.0);
        } else {
            return this.power(this.convert(this.getLeft()).simplify(), this.convert(this.getRight()).simplify());
        }
    }

    public default List<Double> collect() {
        return java.util.stream.Stream.concat(this.convert(this.getLeft()).collect().stream(), this.convert(this.getRight()).collect().stream()).collect(java.util.stream.Collectors.toList());
    }

    public default Tree astree() {
        return new Node(this.convert(this).id(), this.convert(this.getLeft()).astree(), this.convert(this.getRight()).astree());
    }

    public default Integer id() {
        return 77306085;
    }

    public default Boolean equals(Exp<FT> other) {
        return this.convert(this).astree().equals(this.convert(this.convert(other)).astree());
    }

    public default Exp<FT> powby(Exp<FT> other) {
        return this.power(this, this.convert(other));
    }
}
