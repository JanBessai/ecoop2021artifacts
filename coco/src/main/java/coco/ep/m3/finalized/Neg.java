package coco.ep.m3.finalized;

import coco.ep.m2.finalized.Exp;

public class Neg extends Exp implements Factory, coco.ep.m3.Neg<Exp> {

    protected Exp inner;

    public Neg(Exp _inner) {
        this.inner = _inner;
    }

    public Exp getInner() {
        return inner;
    }
}
