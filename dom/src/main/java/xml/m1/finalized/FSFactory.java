package xml.m1.finalized;

import xml.m0.Document;
import xml.m0.finalized.*;
import xml.m1.Schema;

public interface FSFactory extends xml.m0.finalized.FFactory, xml.m1.Factory<FXML, FTag, FDocument> {

    default Schema<FXML, FTag, FDocument> schema(Document<FXML, FTag, FDocument> doc) {
        return new FSchema(doc);
    }

}
