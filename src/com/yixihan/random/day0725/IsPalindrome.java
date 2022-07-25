package com.yixihan.random.day0725;

/**
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * <p>
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 * 例如，121 是回文，而 123 不是。
 * <p>
 * 输入：x = 121
 * 输出：true
 * <p>
 * 输入：x = -121
 * 输出：false
 * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * <p>
 * 输入：x = 10
 * 输出：false
 * 解释：从右向左读, 为 01 。因此它不是一个回文数。
 *
 * @author : yixihan
 * @create : 2022-07-25-9:45
 */
public class IsPalindrome {

    public boolean isPalindrome(int x) {

        char[] arr = Integer.toString (x).toCharArray ();
        int len = arr.length;
        for (int l = 0, r = len - 1; l <= r; l++, r--) {
            if (arr[l] != arr[r]) {
                return false;
            }
        }

        return true;
    }
}
