package xml.m2.finalized;

import xml.m0.XML;

public class FETag implements xml.m2.ETag<FEXML, FETag, FEDocument>, FEXML {
    String name;
    FEXML[] children;

    public FETag(String name, FEXML[] children) {
        this.name = name;
        this.children = children;
    }

    @Override
    public String getName() { return name; }

    @Override
    public FEXML[] getChildren() {
        return children;
    }

    @Override
    public FETag getSelfTag() {
        return this;
    }

    @Override
    public void setChildren(XML<FEXML, FETag, FEDocument>[] children) {
        this.children = new FEXML[children.length];
        for (int i = 0; i < this.children.length; i++) {
            XML<FEXML, FETag, FEDocument> ss = convert(children[i]);
            this.children[i] = convert(children[i]);
        }
    }
}
