package coco.ep.m4;

import java.util.List;

public interface Lit<FT> extends coco.ep.m2.Lit<FT>, Exp<FT> {
	
	default void truncate (int level) {
		// nothing to do
	}
	
    default coco.ep.Exp<FT> simplify() {
        return this;
    }

    default List<Double> collect() {
        return java.util.Arrays.asList(getValue());
    }
}
