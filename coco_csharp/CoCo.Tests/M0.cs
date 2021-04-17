using System;
using Xunit;
using EP.M0;

namespace CoCo.Tests.M0
{
    public interface TestTemplate<FT> : Factory<FT> {
        public void test()
        {
            Exp<FT> expr1 = convert(add(lit(1.0), lit(2.0)));
            Assert.Equal(3.0, expr1.eval());

            Exp<FT> expr2 = convert(lit(2.0));
            Assert.Equal(2.0, expr2.eval());

            Assert.Equal(3.0, convert(add(lit(1.0), lit(2.0))).eval());
            Assert.Equal(5.0, convert(lit(5.0)).eval());
        }
    }

    public class ActualTest : TestTemplate<EP.M0.Finalized.Exp>, EP.M0.Finalized.Factory {}

    public class M0Test
    {
        [Fact]
        public void TestM0()
        {
            TestTemplate<EP.M0.Finalized.Exp> theTest = new ActualTest();
            theTest.test();
        }
    }
}
