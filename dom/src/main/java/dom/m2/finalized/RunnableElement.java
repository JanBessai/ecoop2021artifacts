package dom.m2.finalized;

import dom.m0.finalized.Exp;
import dom.m2.IGenerateOutput;

public class RunnableElement extends dom.m0.finalized.Exp implements Factory, dom.m2.RunnableElement<Exp> {
    protected IGenerateOutput runnable;

    public RunnableElement(IGenerateOutput _runnable) {
        this.runnable = _runnable;
    }

	@Override
	public IGenerateOutput getRunnable() {
		return runnable;
	}

}
