package xml.m2;

import xml.m0.Document;
import xml.m0.Tag;
import xml.m0.XML;

public interface EFactory<FX,FT,FD> extends xml.m1.Factory<FX,FT,FD> {

    EXML<FX,FT,FD> convert(XML<FX,FT,FD> other);
    ETag<FX,FT,FD> convert(Tag<FX,FT,FD> other);
    EDocument<FX,FT,FD> convert(Document<FX,FT,FD> other);
}
