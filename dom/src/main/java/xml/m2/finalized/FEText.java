package xml.m2.finalized;


public class FEText implements xml.m2.EText<FEXML, FETag, FEDocument>, FEXML {
    String text;

    public FEText(String text) {
        this.text = text;
    }

    @Override
    public String getText() {
        return text;
    }
}
