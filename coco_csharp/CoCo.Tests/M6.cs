using System;
using Xunit;
using System.Collections.Generic;
using EP.M6;

namespace CoCo.Tests.M6
{
    public interface TestTemplate<FT> : CoCo.Tests.M5.TestTemplate<FT>, Factory<FT> {
        new public void test()
        {
            CoCo.Tests.M5.TestTemplate<FT> parent = this;
            parent.test();

            EP.M6.Exp<FT> lit1 = convert(lit(1.0));
            EP.M6.Exp<FT> lit2 = convert(lit(2.0));
            EP.M6.Exp<FT> mult1 = convert(mult(lit1, lit2));
            EP.M6.Exp<FT> divd1 = convert(divd(lit1, lit2));
            EP.M6.Exp<FT> add1 = convert(add(lit1, lit2));
            EP.M6.Exp<FT> sub1 = convert(sub(lit1, lit2));
            EP.M6.Exp<FT> neg1 = convert(neg(lit1));

            Assert.True(convert(lit1).equals(convert(lit1)));
            Assert.False(convert(lit1).equals(convert(lit2)));
            Assert.True(convert(mult1).equals(convert(mult1)));
            Assert.False(convert(mult1).equals(convert(divd1)));
            Assert.True(convert(divd1).equals(convert(divd1)));
            Assert.False(convert(divd1).equals(convert(add1)));
            Assert.True(convert(add1).equals(convert(add1)));
            Assert.False(convert(add1).equals(convert(sub1)));
            Assert.True(convert(sub1).equals(convert(sub1)));
            Assert.False(convert(sub1).equals(convert(neg1)));
            Assert.True(convert(neg1).equals(convert(neg1)));
            Assert.False(convert(neg1).equals(convert(mult1)));

            Assert.True(convert(lit1).eql(convert(lit1)));
            Assert.False(convert(lit1).eql(convert(lit2)));
            Assert.False(convert(mult1).eql(convert(lit2)));
            Assert.True(convert(mult1).eql(convert(mult1)));
            Assert.False(convert(mult1).eql(convert(divd1)));
            Assert.True(convert(divd1).eql(convert(divd1)));
            Assert.False(convert(divd1).eql(convert(add1)));
            Assert.True(convert(add1).eql(convert(add1)));
            Assert.False(convert(add1).eql(convert(sub1)));
            Assert.True(convert(sub1).eql(convert(sub1)));
            Assert.False(convert(sub1).eql(convert(neg1)));
            Assert.True(convert(neg1).eql(convert(neg1)));
            Assert.False(convert(neg1).eql(convert(mult1)));

            Assert.True(convert(sub(lit(1.0), lit(73.0))).equals(sub(lit(1.0), lit(73.0))));
            Assert.False(convert(mult(divd(lit(5.0), lit(2.0)), lit(4.0))).equals(mult(divd(lit(5.0), lit(2.0)), lit(3.0))));
            Assert.True(convert(mult(divd(lit(5.0), lit(2.0)), lit(4.0))).equals(mult(divd(lit(5.0), lit(2.0)), lit(4.0))));
            Assert.True(convert(neg(mult(divd(lit(5.0), lit(2.0)), lit(4.0)))).equals(neg(mult(divd(lit(5.0), lit(2.0)), lit(4.0)))));
            Assert.False(convert(mult(divd(lit(5.0), lit(2.0)), lit(4.0))).equals(neg(mult(divd(lit(5.0), lit(2.0)), lit(4.0)))));
            Assert.False(convert(divd(lit(6.0), lit(2.0))).equals(divd(lit(8.0), lit(2.0))));
            Assert.True(convert(divd(lit(6.0), lit(2.0))).equals(divd(lit(6.0), lit(2.0))));
            Assert.True(convert(add(lit(5.0), lit(3.0))).equals(add(lit(5.0), lit(3.0))));
            Assert.False(convert(add(lit(5.0), lit(3.0))).equals(mult(divd(lit(5.0), lit(2.0)), lit(3.0))));
        }
    }

    public class ActualTest : TestTemplate<EP.M6.Finalized.Exp>, EP.M6.Finalized.Factory {}

    public class M6Test
    {
        [Fact]
        public void TestM6()
        {
            TestTemplate<EP.M6.Finalized.Exp> theTest = new ActualTest();
            theTest.test();
        }
    }
}
