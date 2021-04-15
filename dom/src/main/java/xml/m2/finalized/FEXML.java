package xml.m2.finalized;

public interface FEXML extends xml.m2.EXML<FEXML, FETag, FEDocument>, FEFactory {

    default FEXML getSelfXML() { return this; }
}
