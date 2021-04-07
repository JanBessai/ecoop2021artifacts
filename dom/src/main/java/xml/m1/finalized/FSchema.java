package xml.m1.finalized;

import xml.m0.Document;
import xml.m0.finalized.FDocument;
import xml.m0.finalized.FTag;
import xml.m0.finalized.FXML;

public class FSchema implements xml.m1.Schema<FXML, FTag, FDocument>, FXML, FSFactory {
    Document<FXML, FTag, FDocument> document;
    public FSchema(Document<FXML, FTag, FDocument> doc) {
        this.document = doc;
    }

    @Override
    public Document<FXML, FTag, FDocument> getDocument() {
        return document;
    }
}
