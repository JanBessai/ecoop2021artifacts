package coco.ep.m4;

import java.util.List;

public interface Sub<FT> extends coco.ep.m2.Sub<FT>, Exp<FT> {
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
        if (convert(getLeft()).eval().equals(convert(getRight()).eval())) {
            return this.lit(0.0);
        } else {
            return this.sub(convert(getLeft()).simplify(), convert(getRight()).simplify());
        }
    }

    default List<Double> collect() {
        return java.util.stream.Stream.concat(convert(getLeft()).collect().stream(), convert(getRight()).collect().stream()).collect(java.util.stream.Collectors.toList());
    }
}
