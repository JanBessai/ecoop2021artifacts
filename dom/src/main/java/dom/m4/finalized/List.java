package dom.m4.finalized;

public class List extends dom.m3.finalized.Exp implements dom.m4.List<dom.m3.finalized.Exp> {
    protected java.util.List<dom.Exp<dom.m3.finalized.Exp>> items;

    @Override
    public java.util.List<dom.Exp<dom.m3.finalized.Exp>> getItems() {
        return items;
    }

    public List(java.util.List<dom.Exp<dom.m3.finalized.Exp>> items) {
        this.items = new java.util.ArrayList<>();
        this.items.addAll(items);
    }
}
