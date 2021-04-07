package dom.m3;

import dom.m2.IGenerateOutput;

/** Server-side injectable content. */
public interface RunnableElement<FT>  extends Exp<FT>, dom.m2.RunnableElement<FT> {
	
	default String toText() {
		IGenerateOutput r = getRunnable();
		Thread t = new Thread(r);
		t.start();
		
		try {
			t.join();
			return r.getOutput();
		} catch (InterruptedException e) {
			return "Interrupted Exception";
		}
	}
}
