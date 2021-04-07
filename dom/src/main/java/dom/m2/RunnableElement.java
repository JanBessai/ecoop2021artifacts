package dom.m2;

/** Server-side injectable content. */
public interface RunnableElement<FT> extends dom.m0.Exp<FT>, Factory<FT> {
	IGenerateOutput getRunnable();
	
	default String format() {
		IGenerateOutput r = getRunnable();
		Thread t = new Thread(r);
		t.start();
		
		try {
			t.join();
			return r.getOutput();
		} catch (InterruptedException e) {
			return "<p>Interrupted Exception</p>";
		}
	}
}
