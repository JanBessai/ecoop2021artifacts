package xml.m0.finalized;

public interface FXML extends xml.m0.XML<FXML,FTag,FDocument>, FFactory {

    default FXML getSelfXML() { return this; }
}
