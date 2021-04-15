package xml;

import org.junit.Test;
import xml.m0.Document;
import xml.m0.XML;
import xml.m2.finalized.FEDocument;
import xml.m2.finalized.FETag;
import xml.m2.finalized.FEXML;

public class M2Test {

    public interface TestTemplate<FX,FT,FD> extends xml.m2.EFactory<FX,FT,FD>, M1Test.TestTemplate<FX,FT,FD> {
        default void test() {
            M1Test.TestTemplate.super.test();
            Document<FX, FT, FD> doc = this.singleRoot(this.tag("top", this.tag("a"), this.tag("b") ));

            Document<FX, FT, FD> doc2 = this.singleRoot(this.tag("top", this.tag("a"), this.tag("b")));
            Document<FX, FT, FD> doc3 = this.singleRoot(this.tag("top", this.tag("b")));
            XML<FX, FT, FD> schema = this.schema(doc);

            org.junit.Assert.assertTrue(convert(schema).validate(doc2.getRootTag().get()).isEmpty());
            org.junit.Assert.assertFalse(convert(schema).validate(doc3.getRootTag().get()).isEmpty());
        }
    }
    private static class ActualTest implements M2Test.TestTemplate<FEXML, FETag, FEDocument>, xml.m2.finalized.FEFactory {}

    @Test
    public void testTest() { new M2Test.ActualTest().test(); }
}

