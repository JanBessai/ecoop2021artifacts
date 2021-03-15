package coco.ep.m6.finalized;

import coco.ep.m6.finalized.Exp;

public class Neg extends Exp implements coco.ep.m6.Neg<Exp> {

    protected Exp inner;

    public Neg(Exp _inner) {
        this.inner = _inner;
    }

    public Exp getInner() {
        return this.inner;
    }
    
    public void setInner(coco.ep.Exp<Exp> _inner) {
        this.inner = convert(_inner);
    }
}
