package coco.ep.m4;

import java.util.List;

public interface Add<FT> extends coco.ep.m2.Add<FT>, Exp<FT> {

	void setLeft(coco.ep.Exp<FT> left);
	void setRight(coco.ep.Exp<FT> right);
	
	default void truncate (int level) {
		if (level > 1) {
			convert(getLeft()).truncate(level-1);
			convert(getRight()).truncate(level-1);
		} else {
			setLeft(this.lit(convert(getLeft()).eval()));
			setRight(this.lit(convert(getRight()).eval()));
		}
	}
	
    default coco.ep.Exp<FT> simplify() {
        if (Double.valueOf(convert(getLeft()).eval() + convert(getRight()).eval()).equals(0.0)) {
            return this.lit(0.0);
        } else if (convert(getLeft()).eval().equals(0.0)) {
            return convert(getRight()).simplify();
        } else if (convert(getRight()).eval().equals(0.0)) {
            return convert(getLeft()).simplify();
        } else {
            return this.add(convert(getLeft()).simplify(), convert(getRight()).simplify());
        }
    }

    default List<Double> collect() {
        return java.util.stream.Stream.concat(convert(getLeft()).collect().stream(), convert(getRight()).collect().stream()).collect(java.util.stream.Collectors.toList());
    }
}
