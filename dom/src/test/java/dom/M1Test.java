package dom;

import dom.m1.finalized.Factory;
import org.junit.Test;

public class M1Test implements Factory {
	@Test
	public void testTest() {
		Exp<dom.m0.finalized.Exp> title = this.tag("title", "Hello World Page");
		
		java.util.Hashtable<String,String> atts = new java.util.Hashtable<>();
		atts.put("HTTP-EQUIV", "Pragma");
		atts.put("CONTENT", "no-cache");
		Exp<dom.m0.finalized.Exp> meta1 = this.tag("META", "", atts);
		
		atts = new java.util.Hashtable<>();
		atts.put("HTTP-EQUIV", "Expires");
		atts.put("CONTENT", "-1");
		Exp<dom.m0.finalized.Exp> meta2 = this.tag("META", "", atts);
		
		java.util.List<dom.Exp<dom.m0.finalized.Exp>> tags = new java.util.ArrayList<>();
		tags.add(title);
		tags.add(meta1);
		tags.add(meta2);

		Exp<dom.m0.finalized.Exp>  alert = this.script("alert('welcome!');");
		tags.add(alert);
		Exp<dom.m0.finalized.Exp> head = this.block(tags);
		
		tags = new java.util.ArrayList<>();
		tags.add(this.tag("h1", "Hello World!"));
		atts = new java.util.Hashtable<>();
		atts.put("style", "font-family:courier; color:red");
		tags.add(this.tag("p", "This is a test of the new system!", atts));
		Exp<dom.m0.finalized.Exp> body = this.block(tags);
		Exp<dom.m0.finalized.Exp> doc = this.document(head, body);
		System.out.println(convert(doc).format());
	}
}
