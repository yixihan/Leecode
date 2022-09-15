package com.yixihan.random.day0915;

/**
 * 给定一个字符串 s，统计并返回具有相同数量 0 和 1 的非空（连续）子字符串的数量，并且这些子字符串中的所有 0 和所有 1 都是成组连续的。
 * <p>
 * 重复出现（不同位置）的子串也要统计它们出现的次数。
 * <p>
 * 输入：s = "00110011"
 * 输出：6
 * 解释：6 个子串满足具有相同数量的连续 1 和 0 ："0011"、"01"、"1100"、"10"、"0011" 和 "01" 。
 * 注意，一些重复出现的子串（不同位置）要统计它们出现的次数。
 * 另外，"00110011" 不是有效的子串，因为所有的 0（还有 1 ）没有组合在一起。
 * <p>
 * 输入：s = "10101"
 * 输出：4
 * 解释：有 4 个子串："10"、"01"、"10"、"01" ，具有相同数量的连续 1 和 0 。
 *
 * @author : yixihan
 * @create : 2022-09-15-9:55
 */
public class CountBinarySubstrings {

    public int countBinarySubstrings(String s) {
        int last = 0;
        int cur = 1;
        int ans = 0;
        char[] arr = s.toCharArray ();
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                cur++;
            } else {
                last = cur;
                cur = 1;
            }
            if (last >= cur) {
                ans++;
            }
        }

        return ans;
    }
}
