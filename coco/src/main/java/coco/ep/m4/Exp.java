package coco.ep.m4;

import java.util.List;

public interface Exp<FT> extends coco.ep.m2.Exp<FT>, Factory<FT> {

    public abstract coco.ep.Exp<FT> simplify();
    public abstract void truncate(int level);

    public abstract List<Double> collect();
}
