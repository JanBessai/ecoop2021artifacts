package dom.m5.finalized;

public class List extends Exp implements dom.m5.List<Exp> {
    protected java.util.List<dom.Exp<Exp>> items;

    @Override
    public java.util.List<dom.Exp<Exp>> getItems() {
        return items;
    }

    public List(java.util.List<dom.Exp<Exp>> items) {
        this.items = new java.util.ArrayList<>();
        for (dom.Exp<Exp> tag : items) {
            this.items.add(tag);
        }
    }
}
