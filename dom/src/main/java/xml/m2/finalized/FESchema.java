package xml.m2.finalized;

public class FESchema implements xml.m2.ESchema<FEXML, FETag, FEDocument>, FEXML {
    FEDocument document;
    public FESchema(FEDocument doc) {
        this.document = doc;
    }

    @Override
    public FEDocument getDocument() {
        return document;
    }
}
