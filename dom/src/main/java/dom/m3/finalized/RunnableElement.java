package dom.m3.finalized;

import dom.m2.IGenerateOutput;

public class RunnableElement extends dom.m3.finalized.Exp implements dom.m3.RunnableElement<Exp> {
    protected IGenerateOutput runnable;

    public RunnableElement(IGenerateOutput _runnable) {
        this.runnable = _runnable;
    }

	@Override
	public IGenerateOutput getRunnable() {
		return runnable;
	}
}
