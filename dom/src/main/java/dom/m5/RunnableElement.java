package dom.m5;

/** Server-side injectable content. */
public interface RunnableElement<FT>  extends Exp<FT>, dom.m3.RunnableElement<FT> {
	default dom.Exp<FT> reduce() {
		return tag("p", "runnable removed", new java.util.Hashtable<>());
	}
}
