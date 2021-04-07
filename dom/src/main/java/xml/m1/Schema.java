package xml.m1;

import xml.m0.Document;
import xml.m0.XML;

public interface Schema<FX,FT,FD> extends Factory<FX,FT,FD>, XML<FX,FT,FD> {
    Document<FX,FT,FD> getDocument();

    @Override
    default boolean hasTag(String tag) {
        Document<FX, FT, FD> ss = getDocument();
        return getDocument().hasTag(tag);
    }

    @Override
    default boolean addChild(XML<FX, FT, FD> child) {
        return false;
    }

    @Override
    default XML<FX, FT, FD> deepClone() {
        return this.schema(getDocument().deepClone());
    }
}
