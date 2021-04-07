package coco.ep.m6;

public interface Add<FT> extends coco.ep.m5.Add<FT>, Exp<FT> {

    default Boolean equals(coco.ep.Exp<FT> other) {
        return convert(this).astree().equals(convert(other).astree());
    }

    default Boolean isAdd(coco.ep.Exp<FT> left, coco.ep.Exp<FT> right) {
        return convert(left).eql(getLeft()) && convert(right).eql(getRight());
    }

    default Boolean eql(coco.ep.Exp<FT> that) {
        return convert(that).isAdd(convert(getLeft()), convert(getRight()));
    }
}
