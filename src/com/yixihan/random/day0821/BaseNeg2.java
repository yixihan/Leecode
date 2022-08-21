package com.yixihan.random.day0821;

/**
 * 给出数字 N，返回由若干 "0" 和 "1"组成的字符串，该字符串为 N 的负二进制（base -2）表示。
 * <p>
 * 除非字符串就是 "0"，否则返回的字符串中不能含有前导零。
 * <p>
 * 输入：2
 * 输出："110"
 * 解释：(-2) ^ 2 + (-2) ^ 1 = 2
 * <p>
 * 输入：3
 * 输出："111"
 * 解释：(-2) ^ 2 + (-2) ^ 1 + (-2) ^ 0 = 3
 * <p>
 * 输入：4
 * 输出："100"
 * 解释：(-2) ^ 2 = 4
 *
 * @author : yixihan
 * @create : 2022-08-21-9:19
 */
public class BaseNeg2 {

    public String baseNeg2(int n) {
        StringBuilder sb = new StringBuilder ();
        boolean flag = false;

        if (n == 0) {
            return "0";
        }

        while (n > 0) {
            int tmp = n & 1;
            sb.append (tmp);
            n = flag ? (n >> 1) + (n & 1) : n >> 1;
            flag ^= true;
        }

        return sb.reverse ().toString ();
    }
}
