package xml.m1;

import xml.m0.XML;
import xml.m0.Document;

public interface Factory<FX,FT,FD> extends xml.m0.Factory<FX,FT,FD> {
    XML<FX, FT, FD> schema(Document<FX,FT,FD> document);
}