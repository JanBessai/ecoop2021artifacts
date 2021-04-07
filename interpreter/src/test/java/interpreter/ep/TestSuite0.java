package interpreter.ep;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static interpreter.ep.m0.EvalExpFactory.*;

import interpreter.ep.m0.EvalExp;

public class TestSuite0  {

    @Test
    public void test() {
        assertEquals(new Double(3.0), Add(Lit(new Double(1.0)), Lit(new Double(2.0))).eval());
        assertEquals(new Double(5.0), Lit(new Double(5.0)).eval());
        EvalExp cache0 = Add(Lit(new Double(1.0)), Lit(new Double(2.0)));
        EvalExp cache1 = Add(cache0, cache0);
        EvalExp cache2 = Add(cache1, cache1);
        EvalExp cache3 = Add(cache2, cache2);
        EvalExp cache4 = Add(cache3, cache3);
        EvalExp cache5 = Add(cache4, cache4);
        EvalExp cache6 = Add(cache5, cache5);
        EvalExp cache7 = Add(cache6, cache6);
        EvalExp cache8 = Add(cache7, cache7);
        EvalExp cache9 = Add(cache8, cache8);
        EvalExp cache10 = Add(cache9, cache9);
        EvalExp cache11 = Add(cache10, cache10);
        long now11 = System.nanoTime();
        cache11.eval();
        long best11 = System.nanoTime() - now11;
        for (int i = 1; i < 8; i++) {
            now11 = System.nanoTime();
            cache11.eval();
            long duration = System.nanoTime() - now11;
            if (duration < best11) {
                best11 = duration;
            }
        }
        System.out.println(11 + "," + best11);
        long now10 = System.nanoTime();
        cache10.eval();
        long best10 = System.nanoTime() - now10;
        for (int i = 1; i < 8; i++) {
            now10 = System.nanoTime();
            cache10.eval();
            long duration = System.nanoTime() - now10;
            if (duration < best10) {
                best10 = duration;
            }
        }
        System.out.println(10 + "," + best10);
        long now9 = System.nanoTime();
        cache9.eval();
        long best9 = System.nanoTime() - now9;
        for (int i = 1; i < 8; i++) {
            now9 = System.nanoTime();
            cache9.eval();
            long duration = System.nanoTime() - now9;
            if (duration < best9) {
                best9 = duration;
            }
        }
        System.out.println(9 + "," + best9);
        long now8 = System.nanoTime();
        cache8.eval();
        long best8 = System.nanoTime() - now8;
        for (int i = 1; i < 8; i++) {
            now8 = System.nanoTime();
            cache8.eval();
            long duration = System.nanoTime() - now8;
            if (duration < best8) {
                best8 = duration;
            }
        }
        System.out.println(8 + "," + best8);
        long now7 = System.nanoTime();
        cache7.eval();
        long best7 = System.nanoTime() - now7;
        for (int i = 1; i < 8; i++) {
            now7 = System.nanoTime();
            cache7.eval();
            long duration = System.nanoTime() - now7;
            if (duration < best7) {
                best7 = duration;
            }
        }
        System.out.println(7 + "," + best7);
        long now6 = System.nanoTime();
        cache6.eval();
        long best6 = System.nanoTime() - now6;
        for (int i = 1; i < 8; i++) {
            now6 = System.nanoTime();
            cache6.eval();
            long duration = System.nanoTime() - now6;
            if (duration < best6) {
                best6 = duration;
            }
        }
        System.out.println(6 + "," + best6);
        long now5 = System.nanoTime();
        cache5.eval();
        long best5 = System.nanoTime() - now5;
        for (int i = 1; i < 8; i++) {
            now5 = System.nanoTime();
            cache5.eval();
            long duration = System.nanoTime() - now5;
            if (duration < best5) {
                best5 = duration;
            }
        }
        System.out.println(5 + "," + best5);
        long now4 = System.nanoTime();
        cache4.eval();
        long best4 = System.nanoTime() - now4;
        for (int i = 1; i < 8; i++) {
            now4 = System.nanoTime();
            cache4.eval();
            long duration = System.nanoTime() - now4;
            if (duration < best4) {
                best4 = duration;
            }
        }
        System.out.println(4 + "," + best4);
        long now3 = System.nanoTime();
        cache3.eval();
        long best3 = System.nanoTime() - now3;
        for (int i = 1; i < 8; i++) {
            now3 = System.nanoTime();
            cache3.eval();
            long duration = System.nanoTime() - now3;
            if (duration < best3) {
                best3 = duration;
            }
        }
        System.out.println(3 + "," + best3);
        long now2 = System.nanoTime();
        cache2.eval();
        long best2 = System.nanoTime() - now2;
        for (int i = 1; i < 8; i++) {
            now2 = System.nanoTime();
            cache2.eval();
            long duration = System.nanoTime() - now2;
            if (duration < best2) {
                best2 = duration;
            }
        }
        System.out.println(2 + "," + best2);
        long now1 = System.nanoTime();
        cache1.eval();
        long best1 = System.nanoTime() - now1;
        for (int i = 1; i < 8; i++) {
            now1 = System.nanoTime();
            cache1.eval();
            long duration = System.nanoTime() - now1;
            if (duration < best1) {
                best1 = duration;
            }
        }
        System.out.println(1 + "," + best1);
        long now0 = System.nanoTime();
        cache0.eval();
        long best0 = System.nanoTime() - now0;
        for (int i = 1; i < 8; i++) {
            now0 = System.nanoTime();
            cache0.eval();
            long duration = System.nanoTime() - now0;
            if (duration < best0) {
                best0 = duration;
            }
        }
        System.out.println(0 + "," + best0);
    }
}
