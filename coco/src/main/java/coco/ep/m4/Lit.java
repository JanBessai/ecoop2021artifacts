package coco.ep.m4;

import coco.ep.m4.Exp;
import java.util.List;

public interface Lit<FT> extends coco.ep.m2.Lit<FT>, Exp<FT> {
	
	public default void truncate (int level) {
		
	}
	
    public default coco.ep.Exp<FT> simplify() {
        return this;
    }

    public default List<Double> collect() {
        return java.util.Arrays.asList(this.getValue());
    }
}
