package coco.ep.m4;

import java.util.List;

public interface Exp<FT> extends coco.ep.m2.Exp<FT>, Factory<FT> {

    coco.ep.Exp<FT> simplify();
    void truncate(int level);

    List<Double> collect();
}
