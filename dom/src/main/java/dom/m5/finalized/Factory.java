package dom.m5.finalized;

import dom.m2.IGenerateOutput;

public interface Factory extends dom.m5.Factory<dom.m5.finalized.Exp> {

	default dom.m5.finalized.Exp tag(String name, String contents, java.util.Hashtable<String,String> attributes) {
		return new Tag(name, contents, attributes);
	}
	default dom.m5.finalized.Exp tag(String name, String contents) {
		return new Tag(name, contents);
	}

	default dom.m5.finalized.Exp list(java.util.List<dom.Exp<dom.m5.finalized.Exp>> inner) {
		java.util.List<dom.Exp<dom.m5.finalized.Exp>> copied = new java.util.ArrayList<>();
		for (dom.Exp<dom.m5.finalized.Exp> tag:inner) {
			copied.add(convert(tag));
		}
		return new List(copied);
	}

	default dom.m5.finalized.Exp block(java.util.List<dom.Exp<dom.m5.finalized.Exp>> inner) {
		java.util.List<dom.Exp<dom.m5.finalized.Exp>> copied = new java.util.ArrayList<>();
		for (dom.Exp<dom.m5.finalized.Exp> tag:inner) {
			copied.add(convert(tag));
		}
		return new Block(copied);
	}
	
	default dom.m5.finalized.Exp document(dom.Exp<dom.m5.finalized.Exp> head, dom.Exp<dom.m5.finalized.Exp> body) {
		return new Document(convert(head), convert(body));
	}

	default dom.m5.finalized.Exp script(String contents) {
		return new Script(contents);
	}
	
	default dom.m5.finalized.Exp runnableElement(IGenerateOutput runnable) { return new RunnableElement(runnable);	}

	default dom.m5.finalized.Exp table(java.util.List<dom.Exp<dom.m5.finalized.Exp>> header,
									   java.util.List<java.util.List<dom.Exp<dom.m5.finalized.Exp>>> rows,
									   java.util.Hashtable<String,String> attributes) {
		java.util.List<dom.Exp<dom.m5.finalized.Exp>> _header = new java.util.ArrayList<>();
		for (dom.Exp<dom.m5.finalized.Exp> tag:header) {
			_header.add(convert(tag));
		}

		java.util.List<java.util.List<dom.Exp<dom.m5.finalized.Exp>>> _rows = new java.util.ArrayList<>();
		for (java.util.List<dom.Exp<dom.m5.finalized.Exp>> arow : rows) {
			java.util.List<dom.Exp<dom.m5.finalized.Exp>> _row = new java.util.ArrayList<>();

			for (dom.Exp<dom.m5.finalized.Exp> td : arow) {
				_row.add(convert(td));
			}
			_rows.add(_row);
		}
		return new Table(_header, _rows, attributes);
	}

	default dom.m5.finalized.Exp convert(dom.Exp<dom.m5.finalized.Exp> other) { return other.getSelf(); }

}
