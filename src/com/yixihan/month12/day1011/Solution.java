package com.yixihan.month12.day1011;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你长度相等的两个字符串 s1 和 s2 。
 * 一次 字符串交换 操作的步骤如下：选出某个字符串中的两个下标（不必不同），并交换这两个下标所对应的字符。
 * <p>
 * 如果对 其中一个字符串 执行 最多一次字符串交换 就可以使两个字符串相等，返回 true ；否则，返回 false 。
 * <p>
 * 输入：s1 = "bank", s2 = "kanb"
 * 输出：true
 * 解释：例如，交换 s2 中的第一个和最后一个字符可以得到 "bank"
 * <p>
 * 输入：s1 = "attack", s2 = "defend"
 * 输出：false
 * 解释：一次字符串交换无法使两个字符串相等
 * <p>
 * 输入：s1 = "kelb", s2 = "kelb"
 * 输出：true
 * 解释：两个字符串已经相等，所以不需要进行字符串交换
 * <p>
 * 输入：s1 = "abcd", s2 = "dcba"
 * 输出：false
 *
 * @author yixihan
 * @date 2022-10-11-8:53
 */
public class Solution {

    public boolean areAlmostEqual(String s1, String s2) {
        Map<Integer, char[]> map = new HashMap<> ();
        int len = s1.length ();

        for (int i = 0; i < len; i++) {
            if (s1.charAt (i) != s2.charAt (i)) {
                map.put (i, new char[]{s1.charAt (i), s2.charAt (i)});
            }
            if (map.size () > 2) {
                return false;
            }
        }
        if (map.size () == 2) {
            char[][] arr = new char[2][2];
            int index = 0;
            for (char[] value : map.values ()) {
                arr[index++] = value;
            }
            return arr[0][1] == arr[1][0] && arr[0][0] == arr[1][1];
        } else {
            return map.size () == 0;
        }
    }
}
