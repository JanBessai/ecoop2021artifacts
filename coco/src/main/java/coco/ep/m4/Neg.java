package coco.ep.m4;

import java.util.List;

public interface Neg<FT> extends coco.ep.m3.Neg<FT>, Exp<FT> {
	void setInner(coco.ep.Exp<FT> inner);
	
	default void truncate (int level) {
		if (level > 1) {
			convert(getInner()).truncate(level-1);
		} else {
			setInner(this.lit(convert(getInner()).eval()));
		}
	}
	
    default coco.ep.Exp<FT> simplify() {
        if (convert(getInner()).eval().equals(0.0)) {
            return this.lit(0.0);
        } else {
            return this.neg(convert(getInner()).simplify());
        }
    }

    default List<Double> collect() {
        return convert(getInner()).collect();
    }
}
