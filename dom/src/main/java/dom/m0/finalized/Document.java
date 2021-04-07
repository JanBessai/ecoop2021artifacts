package dom.m0.finalized;

public class Document extends Exp implements dom.m0.Document<Exp> {
	protected dom.Exp<Exp> head;
	protected dom.Exp<Exp> body;

	@Override
	public dom.Exp<Exp> getHead() {
		return head;
	}
	
	@Override
	public dom.Exp<Exp> getBody() {
		return body;
	}
	
	public Document(dom.Exp<dom.m0.finalized.Exp> _head, dom.Exp<dom.m0.finalized.Exp> _body) {
		this.head = _head;
		this.body = _body;
	}
}
