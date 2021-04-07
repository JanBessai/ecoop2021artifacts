package dom.m5.finalized;

import java.util.List;

public class Table extends Exp implements dom.m5.Table<Exp> {
	protected List<dom.Exp<Exp>> header;
	protected List<List<dom.Exp<Exp>>> rows;
	protected java.util.Hashtable<String,String> attributes;

	@Override
	public List<dom.Exp<Exp>> getHeader() {
		return header;
	}

	@Override
	public List<List<dom.Exp<Exp>>> getRows() {
		return rows;
	}

	@Override
	public java.util.Hashtable<String,String> getAttributes() { return attributes; }

	public Table(List<dom.Exp<Exp>> header, List<List<dom.Exp<Exp>>> rows, java.util.Hashtable<String,String> atts) {
		this.header = new java.util.ArrayList<>();
		this.rows = new java.util.ArrayList<>();

		this.header.addAll(header);
		this.rows.addAll(rows);
		this.attributes = atts;
	}
}
