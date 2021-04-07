package xml.m0.finalized;

public class FText implements xml.m0.Text<FXML,FTag,FDocument>, FXML {
    String text;

    public FText(String text) {
        this.text = text;
    }

    @Override
    public String getText() {
        return text;
    }
}
