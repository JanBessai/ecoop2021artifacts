package xml.m0.finalized;

public class FSingleRoot implements xml.m0.SingleRoot<FXML, FTag, FDocument>, FDocument {
    FTag root;

    public FSingleRoot(FTag root) {
        this.root = root;
    }

    @Override
    public FTag getRoot() {
        return root;
    }
}
