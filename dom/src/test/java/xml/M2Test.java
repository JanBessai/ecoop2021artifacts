package xml;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import xml.m0.*;
import xml.m0.finalized.*;
import xml.m1.*;
import xml.m1.finalized.*;
import xml.m2.*;
import xml.m2.finalized.*;

public class M2Test {

    public interface TestTemplate<FX,FT,FD> extends EFactory<FX,FT,FD>, M1Test.TestTemplate<FX,FT,FD> {
        default void test() {
            M1Test.TestTemplate.super.test();
            Document<FX, FT, FD> doc = this.singleRoot(this.tag("top", this.tag("a"), this.tag("b")));

            Document<FX, FT, FD> doc2 = this.singleRoot(this.tag("top", this.tag("a"), this.text("ttt"), this.tag("b")));
            Document<FX, FT, FD> doc3 = this.singleRoot(this.tag("top", this.tag("b")));
            Document<FX, FT, FD> doc4 = this.singleRoot(this.tag("top", this.tag("b"), this.text("ttt")));
            Document<FX, FT, FD> doc5 = this.singleRoot(this.tag("top", this.tag("a")));
            Document<FX, FT, FD> doc6 = this.singleRoot(this.tag("top", this.tag("a"), this.tag("b"), this.text("ttt"), this.tag("c")));

            XML<FX, FT, FD> schema = this.schema(doc);

            assertTrue(convert(schema).validate(doc2.getRootTag().get()).isEmpty());
            assertFalse(convert(schema).validate(doc3.getRootTag().get()).isEmpty());
            assertFalse(convert(schema).validate(doc4.getRootTag().get()).isEmpty());
            assertFalse(convert(schema).validate(doc5.getRootTag().get()).isEmpty());
            assertTrue(convert(schema).validate(doc6.getRootTag().get()).isEmpty());

            assertFalse(convert(this.schema(doc2)).validate(doc2.getRootTag().get()).isEmpty());

            assertTrue(this.convert(this.tag("noSchema")).validate(doc.getRootTag().get()).isPresent());
        }
    }
    private static class ActualTest implements M2Test.TestTemplate<FEXML, FETag, FEDocument>, FEFactory {
        @Override public FEDocument emptyDoc() {
            return new FEDocument() {
                @Override public boolean sameRootElements(Document<FEXML,FETag,FEDocument> doc) {
                    return doc.getRootTag().isEmpty();
                }

                @Override public Document<FEXML,FETag,FEDocument> deepClone() {
                    return emptyDoc();
                }

                @Override public boolean hasElem(String text) {
                    return false;
                }

                @Override public boolean addChild(XML<FEXML,FETag,FEDocument> child) {
                    return false;
                }
            };
        }
    }

    @Test
    public void testTest() { new M2Test.ActualTest().test(); }
}

