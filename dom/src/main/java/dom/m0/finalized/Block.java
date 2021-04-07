package dom.m0.finalized;

import java.util.List;

public class Block extends Exp implements dom.m0.Block<Exp> {
	protected java.util.List<dom.Exp<Exp>> tags;

	@Override
	public List<dom.Exp<Exp>> getTags() {
		return tags;
	}
	
	public Block(java.util.List<dom.Exp<dom.m0.finalized.Exp>> tags) {
		this.tags = new java.util.ArrayList<>();
		this.tags.addAll(tags);
	}
}
