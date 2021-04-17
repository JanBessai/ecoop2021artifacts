using System;
using Xunit;
using System.Collections.Generic;
using EP.M4;

namespace CoCo.Tests.M4
{
    public interface TestTemplate<FT> : CoCo.Tests.M3.TestTemplate<FT>, Factory<FT> {
        new public void test()
        {
            CoCo.Tests.M3.TestTemplate<FT> parent = this;
            parent.test();

            EP.Exp<FT> expr1 = divd(lit(3), lit(1));
            Assert.Equal("3", convert(convert(expr1).simplify()).prettyp());

            EP.Exp<FT> expr2 = divd(lit(0), lit(2));
            Assert.Equal("0", convert(convert(expr2).simplify()).prettyp());

            EP.Exp<FT> expr3 = divd(lit(3), divd(lit(6.0), lit(2)));
            Assert.Equal("1", convert(convert(expr3).simplify()).prettyp());

            EP.Exp<FT> expr4 = neg(expr1);
            Assert.Equal("(-3)", convert(convert(expr4).simplify()).prettyp());

            EP.Exp<FT> expr6 = add(lit(-2), lit(2));
            Assert.Equal("0", convert(convert(expr6).simplify()).prettyp());

            EP.Exp<FT> expr7 = add(lit(-2), lit(0));
            Assert.Equal("-2", convert(convert(expr7).simplify()).prettyp());

            EP.Exp<FT> expr8 = add(lit(-2), lit(-5));
            Assert.Equal("(-2+-5)", convert(convert(expr8).simplify()).prettyp());

            EP.Exp<FT> sub2 = sub(lit(3), lit(3));
            Assert.Equal("0", convert(convert(sub2).simplify()).prettyp());

            EP.Exp<FT> neg2 = neg(lit(0));
            Assert.Equal("0", convert(convert(neg2).simplify()).prettyp());

            EP.Exp<FT> left = mult(lit(3), lit(1));
            EP.Exp<FT> right = mult(lit(1), lit(9));
            EP.Exp<FT> expr5 = divd(left, right);
            Assert.Equal("(3/9)", convert(convert(expr5).simplify()).prettyp());

            Assert.Equal(convert(divd(divd(lit(5), lit(7.0)), sub(lit(7.0), mult(lit(2), lit(3))))).collect(), new List<double>() {5, 7.0, 7.0, 2, 3});
            Assert.Equal(convert(add(lit(0), lit(0))).collect(), new List<double>() {0, 0});
            Assert.Equal(convert(neg(lit(0))).collect(), new List<double>() { 0 });
            Assert.Equal(convert(mult(lit(1), lit(12))).collect(), new List<double>() {1, 12});
            Assert.Equal(convert(mult(lit(13), lit(1))).collect(), new List<double>() {13, 1});
            Assert.Equal("((5/2)*4)", convert(mult(divd(lit(5), lit(2)), lit(4))).prettyp());
            Assert.Equal(10, convert(mult(divd(lit(5), lit(2)), lit(4))).eval());

            EP.Exp<FT> h1 = mult(lit(3), lit(2));
            EP.Exp<FT> h2 = mult(h1, h1);
            EP.Exp<FT> threeDeep = mult(h2, h2);

            EP.Exp<FT> mult1 = mult(lit(5), threeDeep);
            convert(mult1).truncate(1);
            Assert.Equal("(5*1296)", convert(mult1).prettyp());

            EP.Exp<FT> divd1 = divd(lit(5), threeDeep);
            convert(divd1).truncate(1);
            Assert.Equal("(5/1296)", convert(divd1).prettyp());

            EP.Exp<FT> neg1 = neg(threeDeep);
            convert(neg1).truncate(1);
            Assert.Equal("(-1296)", convert(neg1).prettyp());

            EP.Exp<FT> sub1 = sub(lit(5), threeDeep);
            convert(sub1).truncate(1);
            Assert.Equal("(5-1296)", convert(sub1).prettyp());

            EP.Exp<FT> baseExp = mult(add(lit(3), lit(7.0)), lit(3));
            String baseExpBeforeTrunc = convert(baseExp).prettyp();
            convert(baseExp).truncate(3);
            Assert.Equal(convert(baseExp).prettyp(), baseExpBeforeTrunc);

            EP.Exp<FT> larger = sub(baseExp, divd(baseExp, lit(1)));
            String largerBeforeTrunc = convert(larger).prettyp();
            convert(larger).truncate(4);
            Assert.Equal(convert(larger).prettyp(), largerBeforeTrunc);

            EP.Exp<FT> nd1 = neg(lit(1));
            EP.Exp<FT> nd2 = neg(nd1);
            EP.Exp<FT> nd3 = neg(nd2);
            Assert.Equal("(-(-(-1)))", convert(nd3).prettyp());
            convert(nd3).truncate(2);

            // looks odd, but is right. The innermost one is the negation of -1
            Assert.Equal("(-(--1))", convert(nd3).prettyp());

            convert(larger).truncate(3);
            EP.Exp<FT> baseExpTrunc = mult(lit(10), lit(3));
            Assert.Equal( convert(baseExp).prettyp(), convert(baseExpTrunc).prettyp());
            EP.Exp<FT> largerTrunc = sub(baseExpTrunc, divd(baseExpTrunc, lit(1)));
            Assert.Equal(convert(larger).prettyp(), convert(largerTrunc).prettyp());
        }
    }

    public class ActualTest : TestTemplate<EP.M4.Finalized.Exp>, EP.M4.Finalized.Factory {}

    public class M4Test
    {
        [Fact]
        public void TestM4()
        {
            TestTemplate<EP.M4.Finalized.Exp> theTest = new ActualTest();
            theTest.test();
        }
    }
}
