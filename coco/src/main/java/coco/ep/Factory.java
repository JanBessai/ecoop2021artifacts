package coco.ep;

public interface Factory<FT> {

    Exp<FT> convert(Exp<FT> other);
}
