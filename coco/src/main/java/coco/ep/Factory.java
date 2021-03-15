package coco.ep;

public interface Factory<FT> {

    public abstract Exp<FT> convert(Exp<FT> other);
}
