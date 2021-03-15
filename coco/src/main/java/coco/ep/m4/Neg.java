package coco.ep.m4;

import coco.ep.m4.Exp;
import java.util.List;

public interface Neg<FT> extends coco.ep.m3.Neg<FT>, Exp<FT> {
	void setInner(coco.ep.Exp<FT> inner);
	
	public default void truncate (int level) {
		if (level > 1) {
			this.convert(this.getInner()).truncate(level-1);
		} else {
			setInner(this.lit(this.convert(this.getInner()).eval()));
		}
	}
	
    public default coco.ep.Exp<FT> simplify() {
        if (Double.valueOf(this.convert(this.getInner()).eval()).equals(0.0)) {
            return this.lit(0.0);
        } else {
            return this.neg(this.convert(this.getInner()).simplify());
        }
    }

    public default List<Double> collect() {
        return this.convert(this.getInner()).collect();
    }
}
