package xml.m0;

public interface Tag<FX,FT,FD> extends XML<FX,FT,FD> {
    String getName();
    XML<FX,FT,FD>[] getChildren();

    FT getSelfTag();

    void setChildren(XML<FX,FT,FD>[] children);

    default Tag<FX,FT,FD> deepClone() {
        int len = getChildren().length;
        XML<FX,FT,FD>[] kids = java.util.Arrays.copyOf(getChildren(), len);
        for (int i = 0; i < len; i++) {
            kids[i] = getChildren()[i].deepClone();
        }
        return this.tag(getName(), kids);
    }

    default boolean hasElem(String text) {
        if (text.equals(getName())) { return true; }

        for (XML<FX,FT,FD> inner : getChildren()) {
            if (inner.hasElem(text)) { return true; }
        }

        return false;
    }

    default boolean addChild(XML<FX,FT,FD> child) {
        int len = getChildren().length;
        XML<FX,FT,FD>[] kids = java.util.Arrays.copyOf(getChildren(), len+1);
        kids[len] = child;
        setChildren(kids);
        return true;
    }
}
