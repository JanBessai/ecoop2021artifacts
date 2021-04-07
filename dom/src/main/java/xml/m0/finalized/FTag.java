package xml.m0.finalized;

import xml.m0.XML;

public class FTag implements xml.m0.Tag<FXML,FTag,FDocument>, FXML {
    String name;
    xml.m0.XML<FXML,FTag,FDocument>[] children;

    public FTag(String name, xml.m0.XML<FXML,FTag,FDocument>[] children) {
        this.name = name;
        this.children = children;
    }

    @Override
    public String getName() { return name; }

    @Override
    public XML<FXML, FTag, FDocument>[] getChildren() {
        return children;
    }

    @Override
    public FTag getSelfTag() {
        return this;
    }

    @Override
    public void setChildren(XML<FXML, FTag, FDocument>[] children) {
        this.children = children;
    }
}
