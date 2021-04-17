using System;
using Xunit;
using System.Collections.Generic;
using EP.M7;

namespace CoCo.Tests.M7
{
    public interface TestTemplate<FT> : CoCo.Tests.M6.TestTemplate<FT>, Factory<FT> {
        new public void test()
        {
            CoCo.Tests.M6.TestTemplate<FT> parent = this;
            parent.test();

            EP.Exp<FT> pby = convert(lit(3.0)).powby(lit(2.0));
            EP.Exp<FT> d1 = convert(divd(lit(5.0), lit(2.0))).powby(lit(2.0));
            EP.Exp<FT> m1 = convert(mult(lit(5.0), lit(2.0))).powby(lit(2.0));
            EP.Exp<FT> a1 = convert(add(lit(5.0), lit(2.0))).powby(lit(2.0));
            EP.Exp<FT> s1 = convert(sub(lit(5.0), lit(3.0))).powby(lit(2.0));
            EP.Exp<FT> n1 = convert(neg(lit(5.0))).powby(lit(2.0));

            Assert.Equal(9.0, convert(pby).eval());
            Assert.Equal(6.25, convert(d1).eval());
            Assert.Equal(100.0, convert(m1).eval());
            Assert.Equal(49.0, convert(a1).eval());
            Assert.Equal(4.0, convert(s1).eval());
            Assert.Equal(25.0, convert(n1).eval());

            Assert.Equal(28561.0, convert(convert(add(lit(1.0), lit(12.0))).powby(lit(4.0))).eval());
        }
    }

    public class ActualTest : TestTemplate<EP.M7.Finalized.Exp>, EP.M7.Finalized.Factory {}

    public class M7Test
    {
        [Fact]
        public void TestM7()
        {
            TestTemplate<EP.M7.Finalized.Exp> theTest = new ActualTest();
            theTest.test();
        }
    }
}
