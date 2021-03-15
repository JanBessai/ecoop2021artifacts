package coco.ep.m7;

import coco.ep.Exp;

public interface Lit<FT> extends coco.ep.m6.Lit<FT>, coco.ep.m7.Exp<FT> {

    public default Exp<FT> powby(Exp<FT> other) {
        Double exponentValue = this.convert(this.convert(other)).eval();
        Exp<FT> result = this;
        Double counter = Math.floor(Math.abs(exponentValue));
        while (1.0 < counter) {
            result = this.mult(result, this);
            counter = counter - 1.0;
        }
        if (this.getValue() < 0.0) {
            result = this.divd(this.lit(1.0), result);
        }
        return result;
    }
}
