package xml.m2.finalized;

import xml.m0.finalized.FDocument;
import xml.m0.finalized.FFactory;
import xml.m0.finalized.FTag;

public interface FEXML extends xml.m2.EXML<FEXML, FETag, FEDocument>, FEFactory {

    default FEXML getSelfXML() { return this; }
}
