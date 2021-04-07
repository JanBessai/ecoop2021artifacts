package coco.ep.i1;

import coco.ep.Exp;

public interface Lit<FT> extends coco.ep.m2.Lit<FT>, coco.ep.i1.Exp<FT> {

    default Exp<FT> multby(Exp<FT> other) {
        Exp<FT> result = this.convert(other);
        Double counter = Math.floor(Math.abs(this.getValue()));
        while (1.0 < counter) {
            result = this.add(result, this.convert(other));
            counter = counter - 1.0;
        }
        if (this.getValue() < 0.0) {
            result = this.sub(this.lit(0.0), result);
        }
        return result;
    }
}
