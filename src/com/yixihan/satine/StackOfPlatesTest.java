package com.yixihan.satine;

import org.junit.jupiter.api.Test;

/**
 * @author : yixihan
 * @create : 2022-03-07-19:24
 */
class StackOfPlatesTest {

    @Test
    public void test() {
        StackOfPlates stack = new StackOfPlates (6);
        stack.push (1);
        stack.push (2);
        stack.push (2);
        stack.popAt (1);
        stack.popAt (3);
        stack.pop ();
        stack.push (2);
        stack.push (2);
        stack.push (2);
        stack.push (2);
        stack.push (2);
        stack.pop ();
        stack.pop ();
        stack.pop ();
        stack.popAt (3);
        stack.popAt (2);
    }

}