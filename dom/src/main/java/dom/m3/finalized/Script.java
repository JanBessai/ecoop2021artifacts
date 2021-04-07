package dom.m3.finalized;

public class Script extends dom.m3.finalized.Exp implements dom.m3.Script<dom.m3.finalized.Exp> {
    protected String contents;

    public Script(String _contents) {
        this.contents = _contents;
    }

	@Override
	public String getContents() {
		return contents;
	}
}
