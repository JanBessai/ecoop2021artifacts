package xml;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import xml.m0.*;
import xml.m0.finalized.*;
import xml.m1.*;
import xml.m1.finalized.*;

public class M1Test {

    public interface TestTemplate<FX,FT,FD> extends xml.m1.Factory<FX,FT,FD>, M0Test.TestTemplate<FX,FT,FD> {
        default void test() {
            M0Test.TestTemplate.super.test();
            Document<FX, FT, FD> doc = this.singleRoot(this.tag("top"));
            Document<FX, FT, FD> doc2 = this.singleRoot(this.tag("top2"));
            XML<FX, FT, FD> schema = this.schema(doc);
            XML<FX, FT, FD> schema2 = this.schema(doc2);
            assertTrue(schema.hasElem("top"));
            assertFalse(doc.sameRootElements(doc2));
            assertTrue(doc.sameRootElements(doc));
            assertTrue(schema.deepClone().hasElem("top"));
            assertFalse(schema.deepClone().hasElem("top2"));
            assertTrue(schema2.deepClone().hasElem("top2"));
            assertFalse(schema2.deepClone().hasElem("top"));
            assertFalse(schema.addChild(this.tag("foo")));
            assertFalse(schema.addChild(this.text("foo")));
        }
    }
    private static class ActualTest implements M1Test.TestTemplate<FXML, FTag, FDocument>, FSFactory {
        @Override public FDocument emptyDoc() {
            return new FDocument() {
                @Override public boolean sameRootElements(Document<FXML,FTag,FDocument> doc) {
                    return doc.getRootTag().isEmpty();
                }

                @Override public Document<FXML,FTag,FDocument> deepClone() {
                    return emptyDoc();
                }

                @Override public boolean hasElem(String text) {
                    return false;
                }

                @Override public boolean addChild(XML<FXML,FTag,FDocument> child) {
                    return false;
                }
            };
        }
    }

    @Test
    public void testTest() { new M1Test.ActualTest().test(); }
}

