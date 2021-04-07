package dom.m5.finalized;

public class Document extends Exp implements dom.m5.Document<dom.m5.finalized.Exp> {
	protected dom.Exp<dom.m5.finalized.Exp> head;
	protected dom.Exp<dom.m5.finalized.Exp> body;

	@Override
	public dom.Exp<dom.m5.finalized.Exp> getHead() {
		return head;
	}
	
	@Override
	public dom.Exp<dom.m5.finalized.Exp> getBody() { return body; }
	
	public Document(dom.Exp<dom.m5.finalized.Exp> _head, dom.Exp<dom.m5.finalized.Exp> _body) {
		this.head = _head;
		this.body = _body;
	}
}
