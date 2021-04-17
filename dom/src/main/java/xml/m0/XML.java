package xml.m0;

public interface XML<FX,FT,FD> extends Factory<FX,FT,FD> {
    FX getSelfXML();

    default boolean notHasElem(String text) {
        return !hasElem(text);
    }

    boolean hasElem(String text);

    boolean addChild(XML<FX,FT,FD> child);

    XML<FX,FT,FD> deepClone();
}
