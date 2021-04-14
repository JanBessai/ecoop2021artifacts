package xml.m2.finalized;


public class FESingleRoot implements xml.m2.ESingleRoot<FEXML, FETag, FEDocument>, FEDocument {
    FETag root;

    public FESingleRoot(FETag root) {
        this.root = root;
    }

    @Override
    public FETag getRoot() {
        return root;
    }
}
