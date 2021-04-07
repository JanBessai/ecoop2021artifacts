package coco.ep.i2;

import coco.ep.i1.Exp;

public interface Power<FT> extends Exp<FT>, Factory<FT> {

    Exp<FT> getLeft();

    Exp<FT> getRight();

    default String prettyp() {
        return "(" + this.convert(this.getLeft()).prettyp() + "^" + this.convert(this.getRight()).prettyp() + ")";
    }

    default coco.ep.Exp<FT> multby(coco.ep.Exp<FT> other) {
        double leftEval = this.convert(this.getLeft()).eval();
        double added = Math.log(convert(other).eval()) / Math.log(leftEval);
        return this.power(this.getLeft(), this.add(this.getRight(), this.lit(added)));
    }

    default Double eval() {
        return Math.pow(this.convert(this.getLeft()).eval(), this.convert(this.getRight()).eval());
    }
}
