package coco.ep.m4;

import coco.ep.m4.Exp;
import java.util.List;

public interface Add<FT> extends coco.ep.m2.Add<FT>, Exp<FT> {

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
	
    public default coco.ep.Exp<FT> simplify() {
        if (Double.valueOf(this.convert(this.getLeft()).eval() + this.convert(this.getRight()).eval()).equals(0.0)) {
            return this.lit(0.0);
        } else if (Double.valueOf(this.convert(this.getLeft()).eval()).equals(0.0)) {
            return this.convert(this.getRight()).simplify();
        } else if (Double.valueOf(this.convert(this.getRight()).eval()).equals(0.0)) {
            return this.convert(this.getLeft()).simplify();
        } else {
            return this.add(this.convert(this.getLeft()).simplify(), this.convert(this.getRight()).simplify());
        }
    }

    public default List<Double> collect() {
        return java.util.stream.Stream.concat(this.convert(this.getLeft()).collect().stream(), this.convert(this.getRight()).collect().stream()).collect(java.util.stream.Collectors.toList());
    }
}
