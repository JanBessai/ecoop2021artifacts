package dom.m5.finalized;

import java.util.List;

public class Block extends Exp implements dom.m5.Block<dom.m5.finalized.Exp> {
	protected List<dom.Exp<dom.m5.finalized.Exp>> tags;

	@Override
	public List<dom.Exp<dom.m5.finalized.Exp>> getTags() {
		return tags;
	}
	
	public Block(List<dom.Exp<dom.m5.finalized.Exp>> tags) {
		this.tags = new java.util.ArrayList<>();
		this.tags.addAll(tags);
	}
}
