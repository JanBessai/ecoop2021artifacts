package xml.m0.finalized;

import xml.m0.XML;

public class FTag implements xml.m0.Tag<FXML,FTag,FDocument>, FXML {
    String name;
    FXML[] children;

    public FTag(String name, FXML[] children) {
        this.name = name;
        this.children = children;
    }

    @Override
    public String getName() { return name; }

    @Override
    public FXML[] getChildren() {
        return children;
    }

    @Override
    public FTag getSelfTag() {
        return this;
    }

    @Override
    public void setChildren(XML<FXML, FTag, FDocument>[] children) {
        this.children = new FXML[children.length];
        for (int i = 0; i < this.children.length; i++) {
            this.children[i] = convert(children[i]);
        }
    }
}
