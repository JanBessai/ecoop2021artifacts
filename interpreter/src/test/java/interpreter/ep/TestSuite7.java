package interpreter.ep;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import static interpreter.ep.m6.EqualsExpFactory.*;
import interpreter.ep.m6.EqualsExp;

public class TestSuite7 {

    @Test
    public void test() {
        assertTrue(Sub(Lit(new Double(1.0)), Lit(new Double(73.0))).equals(Sub(Lit(new Double(1.0)), Lit(new Double(73.0)))));
        assertFalse(Mult(Divd(Lit(new Double(5.0)), Lit(new Double(2.0))), Lit(new Double(4.0))).equals(Mult(Divd(Lit(new Double(5.0)), Lit(new Double(2.0))), Lit(new Double(3.0)))));
        assertTrue(Mult(Divd(Lit(new Double(5.0)), Lit(new Double(2.0))), Lit(new Double(4.0))).equals(Mult(Divd(Lit(new Double(5.0)), Lit(new Double(2.0))), Lit(new Double(4.0)))));
        assertTrue(Neg(Mult(Divd(Lit(new Double(5.0)), Lit(new Double(2.0))), Lit(new Double(4.0)))).equals(Neg(Mult(Divd(Lit(new Double(5.0)), Lit(new Double(2.0))), Lit(new Double(4.0))))));
        assertFalse(Mult(Divd(Lit(new Double(5.0)), Lit(new Double(2.0))), Lit(new Double(4.0))).equals(Neg(Mult(Divd(Lit(new Double(5.0)), Lit(new Double(2.0))), Lit(new Double(4.0))))));
        assertFalse(Divd(Lit(new Double(6.0)), Lit(new Double(2.0))).equals(Divd(Lit(new Double(8.0)), Lit(new Double(2.0)))));
        assertTrue(Divd(Lit(new Double(6.0)), Lit(new Double(2.0))).equals(Divd(Lit(new Double(6.0)), Lit(new Double(2.0)))));
        assertTrue(Add(Lit(new Double(5.0)), Lit(new Double(3.0))).equals(Add(Lit(new Double(5.0)), Lit(new Double(3.0)))));
        assertFalse(Add(Lit(new Double(5.0)), Lit(new Double(3.0))).equals(Mult(Divd(Lit(new Double(5.0)), Lit(new Double(2.0))), Lit(new Double(3.0)))));
        EqualsExp cache12 = Add(Lit(new Double(1.0)), Lit(new Double(2.0)));
        EqualsExp cache13 = Add(Lit(new Double(1.0)), Lit(new Double(2.0)));
        EqualsExp cache14 = Add(cache12, cache12);
        EqualsExp cache15 = Add(cache13, cache13);
        EqualsExp cache16 = Add(cache14, cache14);
        EqualsExp cache17 = Add(cache15, cache15);
        EqualsExp cache18 = Add(cache16, cache16);
        EqualsExp cache19 = Add(cache17, cache17);
        EqualsExp cache20 = Add(cache18, cache18);
        EqualsExp cache21 = Add(cache19, cache19);
        EqualsExp cache22 = Add(cache20, cache20);
        EqualsExp cache23 = Add(cache21, cache21);
        EqualsExp cache24 = Add(cache22, cache22);
        EqualsExp cache25 = Add(cache23, cache23);
        EqualsExp cache26 = Add(cache24, cache24);
        EqualsExp cache27 = Add(cache25, cache25);
        EqualsExp cache28 = Add(cache26, cache26);
        EqualsExp cache29 = Add(cache27, cache27);
        EqualsExp cache30 = Add(cache28, cache28);
        EqualsExp cache31 = Add(cache29, cache29);
        EqualsExp cache32 = Add(cache30, cache30);
        EqualsExp cache33 = Add(cache31, cache31);
        EqualsExp cache34 = Add(cache32, cache32);
        EqualsExp cache35 = Add(cache33, cache33);
        long now23 = System.nanoTime();
        cache35.equals(cache34);
        long best23 = System.nanoTime() - now23;
        for (int i = 1; i < 8; i++) {
            now23 = System.nanoTime();
            cache35.equals(cache34);
            long duration = System.nanoTime() - now23;
            if (duration < best23) {
                best23 = duration;
            }
        }
        System.out.println(11 + "," + best23);
        long now22 = System.nanoTime();
        cache33.equals(cache32);
        long best22 = System.nanoTime() - now22;
        for (int i = 1; i < 8; i++) {
            now22 = System.nanoTime();
            cache33.equals(cache32);
            long duration = System.nanoTime() - now22;
            if (duration < best22) {
                best22 = duration;
            }
        }
        System.out.println(10 + "," + best22);
        long now21 = System.nanoTime();
        cache31.equals(cache30);
        long best21 = System.nanoTime() - now21;
        for (int i = 1; i < 8; i++) {
            now21 = System.nanoTime();
            cache31.equals(cache30);
            long duration = System.nanoTime() - now21;
            if (duration < best21) {
                best21 = duration;
            }
        }
        System.out.println(9 + "," + best21);
        long now20 = System.nanoTime();
        cache29.equals(cache28);
        long best20 = System.nanoTime() - now20;
        for (int i = 1; i < 8; i++) {
            now20 = System.nanoTime();
            cache29.equals(cache28);
            long duration = System.nanoTime() - now20;
            if (duration < best20) {
                best20 = duration;
            }
        }
        System.out.println(8 + "," + best20);
        long now19 = System.nanoTime();
        cache27.equals(cache26);
        long best19 = System.nanoTime() - now19;
        for (int i = 1; i < 8; i++) {
            now19 = System.nanoTime();
            cache27.equals(cache26);
            long duration = System.nanoTime() - now19;
            if (duration < best19) {
                best19 = duration;
            }
        }
        System.out.println(7 + "," + best19);
        long now18 = System.nanoTime();
        cache25.equals(cache24);
        long best18 = System.nanoTime() - now18;
        for (int i = 1; i < 8; i++) {
            now18 = System.nanoTime();
            cache25.equals(cache24);
            long duration = System.nanoTime() - now18;
            if (duration < best18) {
                best18 = duration;
            }
        }
        System.out.println(6 + "," + best18);
        long now17 = System.nanoTime();
        cache23.equals(cache22);
        long best17 = System.nanoTime() - now17;
        for (int i = 1; i < 8; i++) {
            now17 = System.nanoTime();
            cache23.equals(cache22);
            long duration = System.nanoTime() - now17;
            if (duration < best17) {
                best17 = duration;
            }
        }
        System.out.println(5 + "," + best17);
        long now16 = System.nanoTime();
        cache21.equals(cache20);
        long best16 = System.nanoTime() - now16;
        for (int i = 1; i < 8; i++) {
            now16 = System.nanoTime();
            cache21.equals(cache20);
            long duration = System.nanoTime() - now16;
            if (duration < best16) {
                best16 = duration;
            }
        }
        System.out.println(4 + "," + best16);
        long now15 = System.nanoTime();
        cache19.equals(cache18);
        long best15 = System.nanoTime() - now15;
        for (int i = 1; i < 8; i++) {
            now15 = System.nanoTime();
            cache19.equals(cache18);
            long duration = System.nanoTime() - now15;
            if (duration < best15) {
                best15 = duration;
            }
        }
        System.out.println(3 + "," + best15);
        long now14 = System.nanoTime();
        cache17.equals(cache16);
        long best14 = System.nanoTime() - now14;
        for (int i = 1; i < 8; i++) {
            now14 = System.nanoTime();
            cache17.equals(cache16);
            long duration = System.nanoTime() - now14;
            if (duration < best14) {
                best14 = duration;
            }
        }
        System.out.println(2 + "," + best14);
        long now13 = System.nanoTime();
        cache15.equals(cache14);
        long best13 = System.nanoTime() - now13;
        for (int i = 1; i < 8; i++) {
            now13 = System.nanoTime();
            cache15.equals(cache14);
            long duration = System.nanoTime() - now13;
            if (duration < best13) {
                best13 = duration;
            }
        }
        System.out.println(1 + "," + best13);
        long now12 = System.nanoTime();
        cache13.equals(cache12);
        long best12 = System.nanoTime() - now12;
        for (int i = 1; i < 8; i++) {
            now12 = System.nanoTime();
            cache13.equals(cache12);
            long duration = System.nanoTime() - now12;
            if (duration < best12) {
                best12 = duration;
            }
        }
        System.out.println(0 + "," + best12);
    }
}
