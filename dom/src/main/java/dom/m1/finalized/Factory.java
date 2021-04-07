package dom.m1.finalized;

public interface Factory extends dom.m1.Factory<dom.m0.finalized.Exp>, dom.m0.finalized.Factory {

	default dom.m0.finalized.Exp script(String contents) {
		return new Script(contents);
	}

	default dom.m0.finalized.Exp convert(dom.Exp<dom.m0.finalized.Exp> toConvert) { return toConvert.getSelf();	}
}
