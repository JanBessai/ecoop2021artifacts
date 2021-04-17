using System;
using Xunit;
using EP.M3;

namespace CoCo.Tests.M3
{
    public interface TestTemplate<FT> : CoCo.Tests.M2.TestTemplate<FT>, Factory<FT> {
        new public void test()
        {
            CoCo.Tests.M2.TestTemplate<FT> parent = this;
            parent.test();

            EP.Exp<FT> expr1 = this.mult(this.lit(3.0), this.lit(2.0));
            Assert.Equal("(3*2)", convert(expr1).prettyp());

            EP.Exp<FT> expr2 = this.divd(this.lit(3.0), this.lit(2.0));
            Assert.Equal("(3/2)", convert(expr2).prettyp());

            EP.Exp<FT> expr3 = this.neg(this.lit(3.0));
            Assert.Equal("(-3)", convert(expr3).prettyp());

            EP.Exp<FT> expr4 = this.neg(expr1);
            Assert.Equal("(-(3*2))", convert(expr4).prettyp());

            Assert.Equal(convert(this.neg(this.lit(1.0))).eval(), -1.0);
            Assert.Equal("(-1)", convert(this.neg(this.lit(1.0))).prettyp());
            Assert.Equal("((5/2)*4)", convert(this.mult(this.divd(this.lit(5.0), this.lit(2.0)), this.lit(4.0))).prettyp());
            Assert.Equal(10, convert(this.mult(this.divd(this.lit(5.0), this.lit(2.0)), this.lit(4.0))).eval());
            Assert.Equal(convert(this.neg(this.lit(5.0))).eval(), -5.0);
            Assert.Equal("(-(2*3))", convert(this.neg(this.mult(this.lit(2.0), this.lit(3.0)))).prettyp());
        }
    }

    public class ActualTest : TestTemplate<EP.M2.Finalized.Exp>, EP.M3.Finalized.Factory {}

    public class M3Test
    {
        [Fact]
        public void TestM3()
        {
            TestTemplate<EP.M2.Finalized.Exp> theTest = new ActualTest();
            theTest.test();
        }
    }
}
