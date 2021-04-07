package dom.m5.finalized;

public class Script extends Exp implements dom.m5.Script<Exp> {
    protected String contents;

    public Script(String _contents) {
        this.contents = _contents;
    }

	@Override
	public String getContents() {
		return contents;
	}
}
