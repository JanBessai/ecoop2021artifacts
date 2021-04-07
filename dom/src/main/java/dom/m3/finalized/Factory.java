package dom.m3.finalized;

import dom.m2.IGenerateOutput;

public interface Factory extends dom.m3.Factory<dom.m3.finalized.Exp> {

	default dom.m3.finalized.Exp tag(String name, String contents, java.util.Hashtable<String,String> attributes) {
		return new Tag(name, contents, attributes);
	}
	default dom.m3.finalized.Exp tag(String name, String contents) {
		return new Tag(name, contents);
	}
	default dom.m3.finalized.Exp block(java.util.List<dom.Exp<dom.m3.finalized.Exp>>inner) {
		java.util.List<dom.Exp<dom.m3.finalized.Exp>> copied = new java.util.ArrayList<>();
		for (dom.Exp<dom.m3.finalized.Exp> tag:inner) {
			copied.add(convert(tag));
		}
		return new Block(copied);
	}
	
	default dom.m3.finalized.Exp document(dom.Exp<dom.m3.finalized.Exp> head, dom.Exp<dom.m3.finalized.Exp> body) {
		return new Document(head, body);
	}

	default dom.m3.finalized.Exp script(String contents) {
		return new Script(contents);
	}
	
	default dom.m3.finalized.Exp runnableElement(IGenerateOutput runnable) { return new RunnableElement(runnable); }
	
    default dom.m3.finalized.Exp convert(dom.Exp<dom.m3.finalized.Exp> other) {
        return other.getSelf();
    }
}
