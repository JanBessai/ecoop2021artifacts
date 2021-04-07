package xml;

import org.junit.Test;
import xml.m0.Document;
import xml.m0.Factory;
import xml.m0.Tag;
import xml.m0.XML;
import xml.m0.finalized.FDocument;
import xml.m0.finalized.FTag;
import xml.m0.finalized.FXML;

public class M1Test {

    public interface TestTemplate<FX,FT,FD> extends xml.m1.Factory<FX,FT,FD>, M0Test.TestTemplate<FX,FT,FD> {
        default void test() {
            M0Test.TestTemplate.super.test();
            Document<FX, FT, FD> doc = this.singleRoot(this.tag("top"));
            Document<FX, FT, FD> doc2 = this.singleRoot(this.tag("top2"));
            XML<FX, FT, FD> schema = this.schema(doc);
            XML<FX, FT, FD> schema2 = this.schema(doc2);
            org.junit.Assert.assertTrue("",
                    schema.hasTag("top"));
            org.junit.Assert.assertFalse("",
                    doc.sameRootElements(doc2));
            org.junit.Assert.assertTrue("",
                    doc.sameRootElements(doc));

        }
    }
    private static class ActualTest implements M1Test.TestTemplate<FXML, FTag, FDocument>, xml.m1.finalized.FSFactory {}

    @Test
    public void testTest() { new M1Test.ActualTest().test(); }
}

