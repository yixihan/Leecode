package com.yixihan.month05.day0225;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : yixihan
 * @create : 2022-02-25-13:14
 */
class SolutionTest {

    @Test
    void complexNumberMultiply() {
        String num1 = "1+-1i";
        String num2 = "1+-1i";

        String[] split = num1.split ("\\+");
        System.out.println (Arrays.toString (split));

        System.out.println (new Solution ().complexNumberMultiply (num1, num2));
    }
}