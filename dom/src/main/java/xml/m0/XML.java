package xml.m0;

public interface XML<FX,FT,FD> extends Factory<FX,FT,FD> {
    FX getSelfXML();

    default boolean notHasTag(String tag) {
        return !hasTag(tag);
    }

    boolean hasTag(String tag);

    boolean addChild(XML<FX,FT,FD> child);

    XML<FX,FT,FD> deepClone();
}
