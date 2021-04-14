package xml.m2.finalized;

import xml.m0.Document;
import xml.m0.Tag;
import xml.m0.XML;
import xml.m1.Schema;
import xml.m2.EFactory;

public interface FEFactory extends EFactory<FEXML, FETag, FEDocument> {

    @Override
    default XML<FEXML, FETag, FEDocument> text(String name) {
        return new FEText(name);
    }

    @Override
    default Tag<FEXML, FETag, FEDocument> tag(String name, XML<FEXML, FETag, FEDocument>... children) {
        FEXML[] copy = new FEXML[children.length];
        for (int i = 0; i  < copy.length; i++) { copy[i] = convert(children[i]); }
        return new FETag(name, copy);
    }

    @Override
    default Document<FEXML, FETag, FEDocument> singleRoot(Tag<FEXML, FETag, FEDocument> tag) {
        return new FESingleRoot(convert(tag));
    }

    default Schema<FEXML, FETag, FEDocument> schema(Document<FEXML, FETag, FEDocument> doc) { return new FESchema(convert(doc));  }

    @Override
    default FEXML convert(XML<FEXML, FETag, FEDocument> other) {
        return other.getSelfXML();
    }

    @Override
    default FETag convert(Tag<FEXML, FETag, FEDocument> other) {
        return other.getSelfTag();
    }

    @Override
    default FEDocument convert(Document<FEXML, FETag, FEDocument> other) { return other.getSelfDocument();  }
}
