package dom.m3.finalized;

public class Tag extends Exp implements dom.m3.Tag<Exp> {
	protected String name;
	protected java.util.Hashtable<String,String> attributes;
    protected String contents;

    public Tag(String _name, String _contents, java.util.Hashtable<String,String> _atts) {
    	this.name = _name;
        this.contents = _contents;
        this.attributes = _atts;
    }

    public Tag(String _name, String _contents) {
    	this.name = _name;
        this.contents = _contents;
        this.attributes = new java.util.Hashtable<>();
    }
    
    @Override
	public String getName() {
		return name;
	}
    
	@Override
	public String getContents() {
		return contents;
	}

	public java.util.Hashtable<String,String> getAttributes() {
		return attributes;
	}

	protected void setAttributes(java.util.Hashtable<String,String> attributes) {
		this.attributes = attributes;
	}
}
