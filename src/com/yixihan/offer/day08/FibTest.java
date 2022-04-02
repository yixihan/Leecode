package com.yixihan.offer.day08;

import org.junit.jupiter.api.Test;

/**
 * @author : yixihan
 * @create : 2022-02-28-12:54
 */
class FibTest {

    @Test
    void fib() {
        Fib fib = new Fib ();

        System.out.println (fib.fib (2));
        System.out.println (fib.fib (5));
        System.out.println (fib.fib (10));

    }
}