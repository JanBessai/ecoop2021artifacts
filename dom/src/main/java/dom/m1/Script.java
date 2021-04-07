package dom.m1;

/** An executable JavaScript. */
public interface Script<FT> extends dom.m0.Exp<FT>, Factory<FT> {
	String getContents();
	
	default String format() {
		return String.format("<script>%s</script>\n", getContents());
	}
}
