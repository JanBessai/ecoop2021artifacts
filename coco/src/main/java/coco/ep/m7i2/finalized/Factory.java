package coco.ep.m7i2.finalized;

import coco.ep.Exp;
import coco.ep.m7i2.finalized.Add;
import coco.ep.m7i2.finalized.Divd;
import coco.ep.m7i2.finalized.Lit;
import coco.ep.m7i2.finalized.Mult;
import coco.ep.m7i2.finalized.Neg;
import coco.ep.m7i2.finalized.Power;
import coco.ep.m7i2.finalized.Sub;

public interface Factory extends coco.ep.m7i2.Factory<coco.ep.m7i2.finalized.Exp> {

    public default coco.ep.m7i2.finalized.Exp sub(Exp<coco.ep.m7i2.finalized.Exp> left, Exp<coco.ep.m7i2.finalized.Exp> right) {
        return new Sub(this.convert(left), this.convert(right));
    }

    public default coco.ep.m7i2.finalized.Exp power(Exp<coco.ep.m7i2.finalized.Exp> left, Exp<coco.ep.m7i2.finalized.Exp> right) {
        return new Power(this.convert(left), this.convert(right));
    }

    public default coco.ep.m7i2.finalized.Exp lit(Double value) {
        return new Lit(value);
    }

    public default coco.ep.m7i2.finalized.Exp add(Exp<coco.ep.m7i2.finalized.Exp> left, Exp<coco.ep.m7i2.finalized.Exp> right) {
        return new Add(this.convert(left), this.convert(right));
    }

    public default coco.ep.m7i2.finalized.Exp neg(Exp<coco.ep.m7i2.finalized.Exp> inner) {
        return new Neg(this.convert(inner));
    }

    public default coco.ep.m7i2.finalized.Exp mult(Exp<coco.ep.m7i2.finalized.Exp> left, Exp<coco.ep.m7i2.finalized.Exp> right) {
        return new Mult(this.convert(left), this.convert(right));
    }

    public default coco.ep.m7i2.finalized.Exp divd(Exp<coco.ep.m7i2.finalized.Exp> left, Exp<coco.ep.m7i2.finalized.Exp> right) {
        return new Divd(this.convert(left), this.convert(right));
    }

    public default coco.ep.m7i2.finalized.Exp convert(Exp<coco.ep.m7i2.finalized.Exp> other) {
    	Convert.convertCalled++;
        return other.getSelf();
    }
}
