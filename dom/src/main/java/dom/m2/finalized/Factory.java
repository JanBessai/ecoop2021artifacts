package dom.m2.finalized;

import dom.m2.IGenerateOutput;

public interface Factory extends dom.m2.Factory<dom.m0.finalized.Exp>, dom.m1.finalized.Factory {

	default dom.m0.finalized.Exp runnableElement(IGenerateOutput runnable) {
		return new RunnableElement(runnable);
	}
	
	default dom.m0.finalized.Exp convert(dom.Exp<dom.m0.finalized.Exp> toConvert) { return toConvert.getSelf();	}
}
