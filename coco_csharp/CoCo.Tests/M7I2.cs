using System;
using Xunit;
using System.Collections.Generic;
using EP.M7I2;

namespace CoCo.Tests.M7I2
{
    public interface TestTemplate<FT> : CoCo.Tests.M7.TestTemplate<FT>, CoCo.Tests.I2.TestTemplate<FT>, Factory<FT> {
        new public void test()
        {
            CoCo.Tests.M7.TestTemplate<FT> parentM7 = this;
            parentM7.test();
            CoCo.Tests.M7.TestTemplate<FT> parentI2 = this;
            parentI2.test();

            EP.Exp<FT> m = mult(lit(2), lit(5));
            EP.Exp<FT> mb = convert(m).multby(lit(4));

            EP.Exp<FT> pwr = power(lit(2), lit(5));
            EP.Exp<FT> pwr2 = convert(lit(2)).powby(lit(5));

            Assert.False(convert(pwr).eql(mb));
            Assert.False(convert(mb).eql(pwr));

            Assert.True(convert(pwr).equals(pwr2));
            Assert.True(convert(pwr).eql(pwr2));
            Assert.True(convert(pwr2).eql(pwr));

            EP.Exp<FT> negExp = neg(lit(2));
            EP.Exp<FT> neg2 = convert(negExp).powby(lit(5));
            Assert.Equal(-32, convert(neg2).eval());

            EP.Exp<FT> neg3 = convert(negExp).multby(lit(5));
            Assert.Equal(-10, convert(neg3).eval());

            EP.Exp<FT> divd2 = convert(divd(lit(6), lit(2))).multby(lit(5));
            Assert.Equal(15, convert(divd2).eval());

            Assert.Equal(40, convert(mb).eval());
            Assert.Equal("((2*5)*4)", convert(mb).prettyp());

            EP.Exp<FT> expr1 = power(lit(3), lit(1));
            Assert.Equal("3", convert(convert(expr1).simplify()).prettyp());

            EP.Exp<FT> expr2 = power(lit(1), lit(2));
            Assert.Equal("1", convert(convert(expr2).simplify()).prettyp());

            EP.Exp<FT> expr3 = power(lit(3), lit(2));
            Assert.Equal("(3^2)", convert(convert(expr3).simplify()).prettyp());

            // 43046721 = ((9^2)^2)^2
            EP.Exp<FT> h1 = power(lit(43046721), lit(0.5));
            EP.Exp<FT> h2 = power(h1, lit(0.5));
            EP.Exp<FT> threeDeep = power(h2, lit(0.5));

            EP.Exp<FT> pwr1 = power(lit(5), threeDeep);
            convert(pwr1).truncate(1);
            Assert.Equal("(5^9)", convert(pwr1).prettyp());

            Assert.Equal(convert(power(lit(1), lit(12))).collect(), new List<double>() { 1, 12 });

            EP.Exp<FT> pwr3 = power(lit(2), lit(3));
            EP.Exp<FT> pwr4 = convert(pwr3).powby(lit(4));
            Assert.Equal("((2^3)^4)", convert(pwr4).prettyp());
        }
    }

    public class ActualTest : TestTemplate<EP.M7I2.Finalized.Exp>, EP.M7I2.Finalized.Factory {}

    public class M7I2Test
    {
        [Fact]
        public void TestM7I2()
        {
            TestTemplate<EP.M7I2.Finalized.Exp> theTest = new ActualTest();
            theTest.test();
        }
    }
}
