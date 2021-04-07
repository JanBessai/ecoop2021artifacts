package xml.m2;

import xml.m0.Tag;

public interface EXML<FX,FT,FD> extends xml.m0.XML<FX,FT,FD>, EFactory<FX,FT,FD> {

    default java.util.Optional<Tag<FX,FT,FD>> asTag() {
        return java.util.Optional.empty();
    }

    default java.util.Optional<String> validate(Tag<FX,FT,FD> toValidate) {
        return java.util.Optional.of("Invalid validation request.");
    }
}
