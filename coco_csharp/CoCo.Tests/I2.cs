using System;
using Xunit;
using EP.I2;

namespace CoCo.Tests.I2
{
    public interface TestTemplate<FT> : CoCo.Tests.I1.TestTemplate<FT>, Factory<FT> {
        new public void test()
        {
            CoCo.Tests.I1.TestTemplate<FT> parent = this;
            parent.test();

            EP.Exp<FT> pwr = power(lit(2), lit(5));
            EP.Exp<FT> mb = convert(pwr).multby(lit(4)); //mult by 4 just like raising by additional 2

            Assert.Equal(32, convert(pwr).eval());
            Assert.Equal("(2^5)", convert(pwr).prettyp());

            //based upon the CONTEXT (M7I2 or I2) you might get different results for mb
            Assert.True("(2^(5+2))".Equals(convert(mb).prettyp()) ||
                        "((2^5)*4)".Equals(convert(mb).prettyp()));
        }
    }

    public class ActualTest : TestTemplate<EP.I1.Finalized.Exp>, EP.I2.Finalized.Factory {}

    public class I2Test
    {
        [Fact]
        public void TestI2()
        {
            TestTemplate<EP.I1.Finalized.Exp> theTest = new ActualTest();
            theTest.test();
        }
    }
}
