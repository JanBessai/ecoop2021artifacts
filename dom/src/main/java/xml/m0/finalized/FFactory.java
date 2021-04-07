package xml.m0.finalized;

import xml.m0.Document;
import xml.m0.Tag;
import xml.m0.XML;

public interface FFactory extends xml.m0.Factory<FXML,FTag,FDocument> {
    @Override
    default XML<FXML, FTag, FDocument> text(String name) {
        return new FText(name);
    }

    @Override
    default Tag<FXML, FTag, FDocument> tag(String name, XML<FXML, FTag, FDocument>... children) {
        return new FTag(name, children);
    }

    @Override
    default Document<FXML, FTag, FDocument> singleRoot(Tag<FXML, FTag, FDocument> tag) {
        return new FSingleRoot(tag);
    }

    @Override
    default XML<FXML, FTag, FDocument> convert(XML<FXML, FTag, FDocument> other) {
        return other.getSelfXML();
    }

    @Override
    default Tag<FXML, FTag, FDocument> convert(Tag<FXML, FTag, FDocument> other) {
        return other.getSelfTag();
    }

    @Override
    default Document<FXML, FTag, FDocument> convert(Document<FXML, FTag, FDocument> other) {
        return other.getSelfDocument();
    }
}
