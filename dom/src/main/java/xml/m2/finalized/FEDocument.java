package xml.m2.finalized;

public interface FEDocument extends xml.m2.EDocument<FEXML, FETag, FEDocument>, FEXML {

    @Override
    default FEDocument getSelfDocument() {
        return this;
    }
}
