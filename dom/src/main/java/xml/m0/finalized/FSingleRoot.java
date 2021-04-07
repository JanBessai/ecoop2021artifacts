package xml.m0.finalized;

import xml.m0.Tag;

public class FSingleRoot implements xml.m0.SingleRoot<FXML, FTag, FDocument>, FDocument {
    xml.m0.Tag<FXML, FTag, FDocument> root;

    public FSingleRoot(xml.m0.Tag<FXML, FTag, FDocument> root) {
        this.root = root;
    }

    @Override
    public Tag<FXML, FTag, FDocument> getRoot() {
        return root;
    }
}
