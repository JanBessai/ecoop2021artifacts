package coco.ep.m0;

import coco.ep.m0.Exp;

public interface Lit<FT> extends Exp<FT> {

    public abstract Double getValue();

    public default Double eval() {
        return this.getValue();
    }
}
