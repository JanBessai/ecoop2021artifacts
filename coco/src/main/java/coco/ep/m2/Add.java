package coco.ep.m2;

public interface Add<FT> extends coco.ep.m0.Add<FT>, Exp<FT> {

    default String prettyp() {
        return "(" + convert(getLeft()).prettyp() + "+" + convert(getRight()).prettyp() + ")";
    }
}
