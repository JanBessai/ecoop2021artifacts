package coco.ep.m2;

public interface Sub<FT> extends coco.ep.m1.Sub<FT>, Exp<FT> {

    default String prettyp() {
        return "(" + convert(getLeft()).prettyp() + "-" + convert(getRight()).prettyp() + ")";
    }
}
