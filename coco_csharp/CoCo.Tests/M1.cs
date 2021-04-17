using System;
using Xunit;
using EP.M1;

namespace CoCo.Tests.M1
{
    public interface TestTemplate<FT> : CoCo.Tests.M0.TestTemplate<FT>, Factory<FT> {
        new public void test()
        {
            CoCo.Tests.M0.TestTemplate<FT> parent = this;
            parent.test();
            EP.Exp<FT> expr1 = sub(lit(1.0), lit(2.0));
            Assert.Equal(-1.0, convert(expr1).eval());

            EP.Exp<FT> expr2 = lit(2.0);
            Assert.Equal(2.0, convert(expr2).eval());

            Assert.Equal(-1.0, convert(sub(lit(1.0), lit(2.0))).eval());
        }
    }

    public class ActualTest : TestTemplate<EP.M0.Finalized.Exp>, EP.M1.Finalized.Factory {}

    public class M1Test
    {
        [Fact]
        public void TestM1()
        {
            TestTemplate<EP.M0.Finalized.Exp> theTest = new ActualTest();
            theTest.test();
        }
    }
}
