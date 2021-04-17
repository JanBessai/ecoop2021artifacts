using System;
using Xunit;
using EP.I1;

namespace CoCo.Tests.I1
{
    public interface TestTemplate<FT> : CoCo.Tests.M2.TestTemplate<FT>, Factory<FT> {
        new public void test()
        {
            CoCo.Tests.M2.TestTemplate<FT> parent = this;
            parent.test();

            Assert.Equal(-3.0, convert(convert(this.sub(this.lit(1.0), this.lit(2.0))).multby(this.lit(3.0))).eval());

            Assert.Equal(9.0, convert(convert(this.add(this.lit(1.0), this.lit(2.0))).multby(this.lit(3.0))).eval());
        }
    }

    public class ActualTest : TestTemplate<EP.I1.Finalized.Exp>, EP.I1.Finalized.Factory {}

    public class I1Test
    {
        [Fact]
        public void TestI1()
        {
            TestTemplate<EP.I1.Finalized.Exp> theTest = new ActualTest();
            theTest.test();
        }
    }
}
