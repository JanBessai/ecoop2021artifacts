package coco.ep.m6;

public interface Exp<FT> extends coco.ep.m5.Exp<FT>, Factory<FT> {

    default Boolean isLit(Double d) { return false; }
    default Boolean isAdd(coco.ep.Exp<FT> left, coco.ep.Exp<FT> right) { return false; }
    default Boolean isSub(coco.ep.Exp<FT> left, coco.ep.Exp<FT> right) { return false; }
    default Boolean isMult(coco.ep.Exp<FT> left, coco.ep.Exp<FT> right) { return false; }
    default Boolean isNeg(coco.ep.Exp<FT> inner) { return false; }
    default Boolean isDivd(coco.ep.Exp<FT> left, coco.ep.Exp<FT> right) { return false; }

    Boolean equals(coco.ep.Exp<FT> other);
    Boolean eql(coco.ep.Exp<FT> other);
}
