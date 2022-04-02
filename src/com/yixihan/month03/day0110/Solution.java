package com.yixihan.month03.day0110;

/**
 * 累加数 是一个字符串，组成它的数字可以形成累加序列。
 *
 * 一个有效的 累加序列 必须 至少 包含 3 个数。除了最开始的两个数以外，字符串中的其他数都等于它之前两个数相加的和。
 *
 * 给你一个只包含数字 '0'-'9' 的字符串，编写一个算法来判断给定输入是否是 累加数 。如果是，返回 true ；否则，返回 false 。
 *
 * 说明：累加序列里的数 不会 以 0 开头，所以不会出现 1, 2, 03 或者 1, 02, 3 的情况。
 *
 * 输入："112358"
 * 输出：true 
 * 解释：累加序列为: 1, 1, 2, 3, 5, 8 。1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
 *
 * 输入："199100199"
 * 输出：true 
 * 解释：累加序列为: 1, 99, 100, 199。1 + 99 = 100, 99 + 100 = 199
 *
 * @author : yixihan
 * @create : 2022-01-10-6:34
 */
public class Solution {
    public boolean isAdditiveNumber(String num) {

        if (num.length () < 3) {
            return false;
        }

        int len = num.length ();

        for (int i = 1; i <= (len - 1) / 2; i++) {

            if (i > 1 && num.charAt (0) == '0') {
                break;
            }
            for (int j = i + 1; (len - j) >= i && (len - j) >= j - i; j++) {
                if (j - i > 1 && num.charAt (0) == '0') {
                    break;
                }

                String substring1 = num.substring (0, i);
                String substring2 = num.substring (i, j);

                if ((substring2.length () > 1 && substring2.charAt (0) == '0') ||
                        (substring1.length () > 1 && substring1.charAt (0) == '0')) {
                    break;
                }

                long val1 = Long.parseLong (substring1);
                long val2 = Long.parseLong (substring2);
                if (isAdditive (num.substring (j), val1, val2)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isAdditive(String remain, long val1, long val2) {
        if ("".equals (remain)) {
            return true;
        }

        long sum = val1 + val2;
        String str = String.valueOf (sum);
        if (! remain.startsWith (str)) {
            return false;
        }

        return isAdditive (remain.substring (str.length ()), val2, sum);
    }
}
