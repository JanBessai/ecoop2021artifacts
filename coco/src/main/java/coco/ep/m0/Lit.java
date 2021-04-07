package coco.ep.m0;

public interface Lit<FT> extends Exp<FT> {

    Double getValue();

    default Double eval() { return getValue();  }
}
