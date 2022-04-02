package com.yixihan.month06.day0328;

/**
 * 给定一个正整数，检查它的二进制表示是否总是 0、1 交替出现：换句话说，就是二进制表示中相邻两位的数字永不相同。
 * <p>
 * 输入：n = 5
 * 输出：true
 * 解释：5 的二进制表示是：101
 * <p>
 * 输入：n = 7
 * 输出：false
 * 解释：7 的二进制表示是：111.
 * <p>
 * 输入：n = 11
 * 输出：false
 * 解释：11 的二进制表示是：1011.
 *
 * @author : yixihan
 * @create : 2022-03-28-8:02
 */
public class Solution {
    public boolean hasAlternatingBits(int n) {
        String value = Integer.toString (n, 2);
        char[] arr = value.toCharArray ();
        int m = arr.length;
        boolean flag = arr[0] == '1';

        for (int i = 1; i < m; i++) {
            if (flag && arr[i] == '0') {
                flag = false;
            } else if (!flag && arr[i] == '1') {
                flag = true;
            } else {
                return false;
            }
        }
        return true;
    }
}
