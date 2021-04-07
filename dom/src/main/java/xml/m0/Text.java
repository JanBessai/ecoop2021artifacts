package xml.m0;

public interface Text<FX,FT,FD> extends XML<FX,FT,FD> {
    String getText();

    default boolean hasTag(String tag) { return false; }

    default boolean addChild(XML<FX,FT,FD> child) { return false; }

    @Override
    default XML<FX,FT,FD> deepClone() {
        return this.text(getText());
    }
}
