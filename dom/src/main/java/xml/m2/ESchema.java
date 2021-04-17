package xml.m2;

import xml.m0.Document;
import xml.m0.Tag;
import xml.m0.XML;
import xml.m1.Schema;

import java.util.Optional;

public interface ESchema<FX,FT,FD> extends Schema<FX,FT,FD>, EXML<FX,FT,FD> {
    @Override
    default java.util.Optional<String> validate(Tag<FX,FT,FD> toValidate) {
        Document<FX, FT, FD> doc = this.singleRoot(toValidate);
        if (!getDocument().sameRootElements(doc)) {
            return java.util.Optional.of("Root element mismatch!");
        }

        XML<FX, FT, FD>[] childrenToValidate = toValidate.getChildren();

        int idx = 0;
        for (XML<FX, FT, FD> child : getDocument().getRootTag().get().getChildren()) {
            Optional<Tag<FX, FT, FD>> tag = convert(child).asTag();
            if (tag.isEmpty()) {
                return java.util.Optional.of("Schema can only include tags");
            } else {
                Optional<Tag<FX, FT, FD>> tagToValidate = Optional.empty();
                while (tagToValidate.isEmpty() && idx < childrenToValidate.length) {
                    tagToValidate = convert(childrenToValidate[idx]).asTag();
                    idx++;
                }
                if (tagToValidate.isEmpty()) {
                    return java.util.Optional.of("Missing tag:" + tag.get().getName());
                }

                XML<FX, FT, FD> matcher = this.schema(this.singleRoot(tag.get()));
                Optional<String> result = convert(matcher).validate(tagToValidate.get());
                if (result.isPresent()) {
                    return result;  // the error which was found
                }
            }
        }

        return Optional.empty();
    }
}
