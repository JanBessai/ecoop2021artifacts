package xml.m0;

public interface Document<FX,FT,FD> extends XML<FX,FT,FD> {
    FD getSelfDocument();
    boolean sameRootElements(Document<FX,FT,FD> doc);

    Document<FX,FT,FD> deepClone();

    default java.util.Optional<Tag<FX,FT,FD>> getRootTag() {
        return java.util.Optional.empty();
    }
}
