package coco.ep.m2;

public interface Lit<FT> extends coco.ep.m0.Lit<FT>, Exp<FT> {

    default String prettyp() {
        return String.valueOf(getValue());
    }
}
