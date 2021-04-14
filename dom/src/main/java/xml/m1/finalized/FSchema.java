package xml.m1.finalized;

import xml.m0.finalized.FDocument;
import xml.m0.finalized.FTag;
import xml.m0.finalized.FXML;

public class FSchema implements xml.m1.Schema<FXML, FTag, FDocument>, FXML, FSFactory {
    FDocument document;
    public FSchema(FDocument doc) {
        this.document = doc;
    }

    @Override
    public FDocument getDocument() {
        return document;
    }
}
