package xml.m0;

public interface Factory<FX,FT,FD> {
    XML<FX,FT,FD> text(String name);

    Tag<FX,FT,FD> tag(String name, XML<FX, FT, FD>... children);

    Document<FX,FT,FD> singleRoot(Tag<FX,FT,FD> tag);

    XML<FX,FT,FD> convert(XML<FX,FT,FD> other);
    Tag<FX,FT,FD> convert(Tag<FX,FT,FD> other);
    Document<FX,FT,FD> convert(Document<FX,FT,FD> other);
}
