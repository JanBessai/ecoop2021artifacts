package dom;

import java.util.Date;
import org.junit.Test;

import dom.m4.finalized.Factory;
import dom.m2.IGenerateOutput;

public class M4Test implements Factory {
	@Test
	public void testTest() {
		Exp<dom.m3.finalized.Exp> title = this.tag("title", "Hello World Page");
		
		java.util.Hashtable<String,String> atts = new java.util.Hashtable<>();
		atts.put("HTTP-EQUIV", "Pragma");
		atts.put("CONTENT", "no-cache");
		Exp<dom.m3.finalized.Exp> meta1 = this.tag("META", "", atts);
		
		atts = new java.util.Hashtable<>();
		atts.put("HTTP-EQUIV", "Expires");
		atts.put("CONTENT", "-1");
		Exp<dom.m3.finalized.Exp> meta2 = this.tag("META", "", atts);
		
		java.util.List<Exp<dom.m3.finalized.Exp>> tags = new java.util.ArrayList<>();
		tags.add(title);
		tags.add(meta1);
		tags.add(meta2);

		Exp<dom.m3.finalized.Exp> alert = this.script("alert('welcome!');");
		tags.add(alert);
		Exp<dom.m3.finalized.Exp> head = this.block(tags);
		
		tags = new java.util.ArrayList<>();
		tags.add(this.tag("h1", "Hello World!"));
		atts = new java.util.Hashtable<>();
		atts.put("style", "font-family:courier; color:red");
		tags.add(this.tag("p", "This is a test of the new system!", atts));
		
		IGenerateOutput curDateAndTime = new IGenerateOutput () {
			StringBuffer outputGenerated = new StringBuffer();
			public String getOutput() { 
				return outputGenerated.toString(); 
			}

			public void run() {
				outputGenerated.append(new Date().toString()).append("\n");
			}
		};
		
		tags.add(this.runnableElement(curDateAndTime));

		// list
		java.util.List<Exp<dom.m3.finalized.Exp>> entries = new java.util.ArrayList<>();
		entries.add(this.tag("p", "Clubs", new java.util.Hashtable<>()));
		entries.add(this.tag("p", "Diamonds", new java.util.Hashtable<>()));
		entries.add(this.tag("p", "Hearts", new java.util.Hashtable<>()));
		entries.add(this.tag("p", "Spades", new java.util.Hashtable<>()));
		tags.add(this.list(entries));
		Exp<dom.m3.finalized.Exp> body = this.block(tags);
		Exp<dom.m3.finalized.Exp> doc = this.document(head, body);
		
		System.out.println(convert(doc).toText());
	}
}
