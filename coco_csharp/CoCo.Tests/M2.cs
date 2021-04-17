using System;
using Xunit;
using EP.M2;

namespace CoCo.Tests.M2
{
    public interface TestTemplate<FT> : CoCo.Tests.M1.TestTemplate<FT>, Factory<FT> {
        new public void test()
        {
            CoCo.Tests.M1.TestTemplate<FT> parent = this;
            parent.test();
            EP.Exp<FT> expr1 = add(lit(1.0), lit(2.0));
            Assert.Equal("(1+2)", convert(expr1).prettyp());

            EP.Exp<FT> expr2 = lit(2.0);
            Assert.Equal("2", convert(expr2).prettyp());

            Assert.Equal("(1-2)", convert(sub(lit(1.0), lit(2.0))).prettyp());
            Assert.Equal("((1-2)+(5+6))", convert(add(sub(lit(1.0), lit(2.0)), add(lit(5.0), lit(6.0)))).prettyp());
        }
    }

    public class ActualTest : TestTemplate<EP.M2.Finalized.Exp>, EP.M2.Finalized.Factory {}

    public class M2Test
    {
        [Fact]
        public void TestM2()
        {
            TestTemplate<EP.M2.Finalized.Exp> theTest = new ActualTest();
            theTest.test();
        }
    }
}
