package dom.m0;

public interface Document<FT> extends dom.m0.Exp<FT> {
	dom.Exp<FT> getHead();
	dom.Exp<FT> getBody();
	
	default String format() {
		StringBuilder sb = new StringBuilder("<html>\n");
		sb.append(String.format("<head>%s</head>\n", convert(getHead()).format()));
		sb.append(String.format("<body>%s</body>\n", convert(getBody()).format()));
		sb.append("</html>");
		return sb.append("\n").toString();
	}
}
