package coco.ep.m7.finalized;

public class Neg extends Exp implements coco.ep.m7.Neg<Exp> {

    protected Exp inner;

    public Neg(Exp _inner) {
        this.inner = _inner;
    }

    public Exp getInner() {
        return inner;
    }
    
    public void setInner(coco.ep.Exp<Exp> _inner) {
        inner = convert(_inner);
    }
}
