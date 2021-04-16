package xml;

import org.junit.jupiter.api.Test;
import xml.m0.Factory;
import xml.m0.Tag;

public class M0Test {
    public interface TestTemplate<FX,FT,FD> extends Factory<FX,FT,FD> {
        default void test() {

            Tag<FX,FT,FD> tag = this.tag("html");
            org.junit.jupiter.api.Assertions.assertTrue(tag.addChild(this.tag("head")));
            org.junit.jupiter.api.Assertions.assertTrue(tag.addChild(this.tag("body")));

            org.junit.jupiter.api.Assertions.assertTrue(tag.hasTag("body"));
            org.junit.jupiter.api.Assertions.assertTrue(tag.notHasTag("script"));
        }
    }

    private static class ActualTest implements TestTemplate<xml.m0.finalized.FXML,xml.m0.finalized.FTag,xml.m0.finalized.FDocument>, xml.m0.finalized.FFactory {}

    @Test
    public void testTest() { new ActualTest().test(); }
}
