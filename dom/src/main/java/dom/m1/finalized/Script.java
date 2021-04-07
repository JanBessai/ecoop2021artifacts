package dom.m1.finalized;

public class Script extends dom.m0.finalized.Exp implements Factory, dom.m1.Script<dom.m0.finalized.Exp> {
    protected String contents;

    public Script(String _contents) {
        this.contents = _contents;
    }

	@Override
	public String getContents() {
		return contents;
	}
}
