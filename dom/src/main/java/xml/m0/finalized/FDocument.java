package xml.m0.finalized;

public interface FDocument extends xml.m0.Document<FXML,FTag,FDocument>, FXML {

    @Override
    default FDocument getSelfDocument() {
        return this;
    }
}
