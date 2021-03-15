package coco.ep.i2;

import coco.ep.i1.Exp;

public interface Power<FT> extends Exp<FT>, Factory<FT> {

    public abstract Exp<FT> getLeft();

    public abstract Exp<FT> getRight();

    public default String prettyp() {
        return "(" + this.convert(this.getLeft()).prettyp() + "^" + this.convert(this.getRight()).prettyp() + ")";
    }

    public default coco.ep.Exp<FT> multby(coco.ep.Exp<FT> other) {
        return this.power(this.getLeft(), this.add(this.getRight(), this.lit(Math.log(2.718281828459045) / Math.log(this.convert(this.getRight()).eval()) / Math.log(2.718281828459045) / Math.log(this.convert(this.getLeft()).eval()))));
    }

    public default Double eval() {
        return Math.pow(this.convert(this.getLeft()).eval(), this.convert(this.getRight()).eval());
    }
}
