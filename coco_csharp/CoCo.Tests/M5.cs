using System;
using Xunit;
using System.Collections.Generic;
using EP.M5;

namespace CoCo.Tests.M5
{
    public interface TestTemplate<FT> : CoCo.Tests.M4.TestTemplate<FT>, Factory<FT> {
        new public void test()
        {
            CoCo.Tests.M4.TestTemplate<FT> parent = this;
            parent.test();

            Exp<FT> lit1 = convert(lit(1.0));
            Exp<FT> lit2 = convert(lit(2.0));
            Exp<FT> mult1 = convert(mult(lit1, lit2));
            Exp<FT> divd1 = convert(divd(lit1, lit2));
            Exp<FT> add1 = convert(add(lit1, lit2));
            Exp<FT> sub1 = convert(sub(lit1, lit2));
            Exp<FT> neg1 = convert(neg(lit1));

            Assert.Equal(lit1.id(), lit2.id());
            Assert.Equal(mult1.id(), convert(mult(lit1, lit2)).id());
            Assert.Equal(convert(divd1).id(), convert(divd(lit1, lit2)).id());
            Assert.Equal(convert(sub1).id(), convert(sub(lit1, lit2)).id());
            Assert.Equal(convert(add1).id(), convert(add(lit1, lit2)).id());
            Assert.Equal(convert(neg1).id(), convert(neg(lit2)).id());

            Node n1 = new Node(lit1.id(), new Leaf(1.0));
            Node n2 = new Node(lit2.id(),  new Leaf(2.0));
            Tree m3 = new Node(mult1.id(), n1, n2);
            Assert.Equal(m3, convert(mult(lit1, lit2)).astree());

            Tree d3 = new Node(divd1.id(), n1, n2);
            Assert.Equal(d3, convert(divd(lit1, lit2)).astree());

            Tree n3 = new Node(neg1.id(), n1);
            Assert.Equal(n3, convert(neg(lit1)).astree());

            Tree a3 = new Node(add1.id(), n1, n2);
            Assert.Equal(a3, convert(add(lit1, lit2)).astree());

            Tree s3 = new Node(sub1.id(), n1, n2);
            Assert.Equal(s3, convert(sub(lit1, lit2)).astree());

            Assert.True(convert(sub(neg(lit(2.0)), mult(sub(lit(1.0), lit(976.0)), add(mult(lit(1.0), lit(976.0)), divd(lit(1.0), lit(3.0)))))).astree().Equals(new Node(83488, new Node(78192, new Node(76407, new Leaf(2.0))), new Node(2409808, new Node(83488, new Node(76407, new Leaf(1.0)), new Node(76407, new Leaf(976.0))), new Node(65665, new Node(2409808, new Node(76407, new Leaf(1.0)), new Node(76407, new Leaf(976.0))), new Node(2130451, new Node(76407, new Leaf(1.0)), new Node(76407, new Leaf(3.0))))))));
            Assert.True(convert(sub(neg(lit(2.0)), mult(sub(lit(1.0), lit(976.0)), add(mult(lit(1.0), lit(976.0)), divd(lit(1.0), lit(3.0)))))).prettyp().Equals("((-2)-((1-976)*((1*976)+(1/3))))"));
            Assert.True(convert(convert(mult(mult(lit(2.0), lit(1.0)), add(lit(0.0), lit(7.0)))).simplify()).astree().Equals(new Node(2409808, new Node(76407, new Leaf(2.0)), new Node(76407, new Leaf(7.0)))));
        }
    }

    public class ActualTest : TestTemplate<EP.M5.Finalized.Exp>, EP.M5.Finalized.Factory {}

    public class M5Test
    {
        [Fact]
        public void TestM5()
        {
            TestTemplate<EP.M5.Finalized.Exp> theTest = new ActualTest();
            theTest.test();
        }
    }
}
