package dom.m0.finalized;

public interface Factory extends dom.m0.Factory<dom.m0.finalized.Exp> {

	default dom.m0.finalized.Exp tag(String name, String contents, java.util.Hashtable<String,String> attributes) {
		return new Tag(name, contents, attributes);
	}
	default dom.m0.finalized.Exp tag(String name, String contents) {
		return new Tag(name, contents);
	}
	default dom.m0.finalized.Exp document(dom.Exp<dom.m0.finalized.Exp> head, dom.Exp<dom.m0.finalized.Exp> body) {
		return new Document(head, body);
	}
	
	default dom.m0.finalized.Exp block(java.util.List<dom.Exp<dom.m0.finalized.Exp>> inner) {
		java.util.List<dom.Exp<dom.m0.finalized.Exp>> copied = new java.util.ArrayList<>();
		for (dom.Exp<dom.m0.finalized.Exp> tag:inner) {
			copied.add(convert(tag));
		}
		return new Block(copied);
	}

	default dom.m0.finalized.Exp convert(dom.Exp<dom.m0.finalized.Exp> other) {
		return other.getSelf();
	}
}
