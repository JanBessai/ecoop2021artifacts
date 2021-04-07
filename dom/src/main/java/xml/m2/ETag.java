package xml.m2;

import xml.m0.Tag;

public interface ETag<FX,FT,FD> extends Tag<FX,FT,FD>, EXML<FX,FT,FD> {
    @Override
    default java.util.Optional<Tag<FX,FT,FD>> asTag() {
        return java.util.Optional.of(this);
    }
}
