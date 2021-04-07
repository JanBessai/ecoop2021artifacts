package dom.m3.finalized;

public class Document extends Exp implements dom.m3.Document<Exp> {
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
	
	public Document(dom.Exp<Exp> _head, dom.Exp<Exp> _body) {
		this.head = _head;
		this.body = _body;
	}
}
