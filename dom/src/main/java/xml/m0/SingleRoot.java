package xml.m0;

import java.util.Optional;

public interface SingleRoot<FX,FT,FD> extends Document<FX,FT,FD> {
    Tag<FX,FT,FD> getRoot();

    default java.util.Optional<Tag<FX,FT,FD>> getRootTag() {
        return java.util.Optional.of(getRoot());
    }

    default boolean hasElem(String text) {
        return getRoot().hasElem(text);
    }

    @Override
    default boolean addChild(XML<FX, FT, FD> child) {
        return false;
    }

    @Override
    default Document<FX, FT, FD> deepClone() {
        return this.singleRoot(getRoot().deepClone());
    }

    default boolean sameRootElements(Document<FX,FT,FD> other) {
        Optional<Tag<FX, FT, FD>> root = other.getRootTag();
        if (root.isPresent()) {
            return root.get().getName().equals(getRoot().getName());
        }

        return false;
    }
}
