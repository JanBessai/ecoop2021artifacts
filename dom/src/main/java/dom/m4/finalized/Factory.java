package dom.m4.finalized;

public interface Factory extends dom.m4.Factory<dom.m3.finalized.Exp>, dom.m3.finalized.Factory {

	default dom.m3.finalized.Exp list(java.util.List<dom.Exp<dom.m3.finalized.Exp>> inner) {
		java.util.List<dom.Exp<dom.m3.finalized.Exp>> copied = new java.util.ArrayList<>();
		for (dom.Exp<dom.m3.finalized.Exp> tag:inner) {
			copied.add(convert(tag));
		}
		return new List(copied);
	}

	default dom.m3.finalized.Exp convert(dom.Exp<dom.m3.finalized.Exp> toConvert) { return toConvert.getSelf(); }
}
