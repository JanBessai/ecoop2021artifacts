package xml;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import xml.m0.*;
import xml.m0.finalized.*;

public class M0Test {
    public interface TestTemplate<FX,FT,FD> extends Factory<FX,FT,FD> {
        default void test() {
            Tag<FX,FT,FD> tag = this.tag("html");
            assertTrue(tag.addChild(this.tag("head")));
            assertTrue(tag.addChild(this.tag("body")));

            assertTrue(tag.hasElem("body"));
            assertTrue(tag.notHasElem("script"));
            assertTrue(tag.deepClone().hasElem("head"));
            assertTrue(tag.deepClone().hasElem("body"));
            assertTrue(tag.deepClone().notHasElem("script"));

            XML<FX, FT, FD> text = this.text("test");
            assertTrue(text.hasElem("test"));
            assertTrue(text.notHasElem("html"));
            assertFalse(text.addChild(tag));
            assertFalse(text.addChild(text));
            text.deepClone().hasElem("test");
            text.deepClone().notHasElem("Test");

            Document<FX,FT,FD> singleRoot = this.singleRoot(tag);
            assertTrue(singleRoot.getRootTag().isPresent());
            assertSame(singleRoot.getRootTag().get(), tag);
            assertTrue(singleRoot.hasElem("body"));
            assertTrue(singleRoot.notHasElem("script"));
            assertTrue(singleRoot.deepClone().hasElem("head"));
            assertTrue(singleRoot.deepClone().hasElem("body"));
            assertTrue(singleRoot.deepClone().notHasElem("script"));
            assertTrue(singleRoot.sameRootElements(singleRoot.deepClone()));
            assertFalse(singleRoot.addChild(text));
            assertFalse(singleRoot.addChild(tag.deepClone()));
            assertFalse(singleRoot.sameRootElements(this.singleRoot(this.tag("head"))));
            assertFalse(singleRoot.sameRootElements(emptyDoc()));
        }

        Document<FX, FT, FD> emptyDoc();
    }

    private static class ActualTest implements TestTemplate<FXML, FTag, FDocument>, FFactory {
        @Override public xml.m0.finalized.FDocument emptyDoc() {
            return new xml.m0.finalized.FDocument() {
                @Override public boolean sameRootElements(Document<FXML, FTag, FDocument> doc) {
                    return doc.getRootTag().isEmpty();
                }

                @Override public Document<FXML, FTag, FDocument> deepClone() {
                    return emptyDoc();
                }

                @Override public boolean hasElem(String text) {
                    return false;
                }

                @Override public boolean addChild(XML<FXML, FTag, FDocument> child) {
                    return false;
                }
            };
        }
    }

    @Test
    public void testTest() { new ActualTest().test(); }
}
