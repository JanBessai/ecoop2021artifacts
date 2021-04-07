package dom.m5.finalized;

import dom.m2.IGenerateOutput;

public class RunnableElement extends Exp implements dom.m5.RunnableElement<Exp> {
    protected IGenerateOutput runnable;

    public RunnableElement(IGenerateOutput _runnable) {
        this.runnable = _runnable;
    }

	@Override
	public IGenerateOutput getRunnable() {
		return runnable;
	}
}
