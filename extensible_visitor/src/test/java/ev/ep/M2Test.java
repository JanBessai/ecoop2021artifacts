package ev.ep;

import ev.ep.m0.Add;
import ev.ep.m0.Lit;
import ev.ep.m1.EvalSub;
import ev.ep.m1.Sub;
import ev.ep.m2.Prettyp;
import org.junit.Assert;
import org.junit.Test;

public class M2Test {

    public static class TestTemplate {
        void test() {
           
            Add expr1 = new Add(new Lit(1.0), new Lit(2.0));
            
            Assert.assertEquals("(1.0+2.0)", expr1.accept(this.makePrettyp()));

            Lit expr2 = new Lit(2.0);
            Assert.assertEquals("2.0", expr2.accept(this.makePrettyp()));

            Assert.assertEquals("(1.0-2.0)", new Sub(new Lit(1.0), new Lit(2.0)).accept(this.makePrettyp()));
            Assert.assertEquals("((1.0-2.0)+(5.0+6.0))", new Add(new Sub(new Lit(1.0), new Lit(2.0)), new Add(new Lit(5.0), new Lit(6.0))).accept(this.makePrettyp()));
        }


        public EvalSub makeEval() {
            return new EvalSub();
        }

        public Prettyp makePrettyp() {
            return new Prettyp();
        }
    }
 
    @Test
    public void testTest() { new TestTemplate().test(); }
}
