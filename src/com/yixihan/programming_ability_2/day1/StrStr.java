package com.yixihan.programming_ability_2.day1;

/**
 * 实现 strStr() 函数。
 * <p>
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。
 * 如果不存在，则返回  -1 。
 * <p>
 * 说明：
 * <p>
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * <p>
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。
 * <p>
 * <p>
 * 输入：haystack = "hello", needle = "ll"
 * 输出：2
 * <p>
 * 输入：haystack = "aaaaa", needle = "bba"
 * 输出：-1
 * <p>
 * 输入：haystack = "", needle = ""
 * 输出：0
 * <p>
 * 自己写的题解 ： https://leetcode-cn.com/problems/implement-strstr/solution/sunday-by-yixihan-3jl2/
 *
 * @author : yixihan
 * @create : 2022-03-23-11:17
 */
public class StrStr {
    public int strStr(String haystack, String needle) {

        // 方法一 : 暴力解
        //        if (needle == null || needle.length () == 0) {
        //            return 0;
        //        }
        //
        //        int h = haystack.length ();
        //        int n = needle.length ();
        //
        //        for (int i = 0; i <= h - n; i++) {
        //            String val = haystack.substring (i, i + n);
        //            if (needle.equals (val)) {
        //                return i;
        //            }
        //        }
        //
        //        return -1;

        // 输入合法性校验
        if (needle == null || needle.length () == 0) {
            return 0;
        } else if (needle.length () > haystack.length ()) {
            return -1;
        }

        char[] charH = haystack.toCharArray ();
        char[] charN = needle.toCharArray ();
        int h = charH.length;
        int n = charN.length;

        for (int i = 0; i < h; ) {
            for (int j = 0; j < n; ) {
                // 判断 i + n 是否过界, 此处不能用 >=
                if (i + n > h) {
                    return -1;
                }
                // 相等则继续匹配
                if (charH[i + j] == charN[j]) {
                    j++;

                    // 当子串匹配完则表示已找到位置
                    if (j >= n) {
                        return i;
                    }
                } else {
                    // 防止 charH[i + n] 越界
                    if (i + n >= h) {
                        return -1;
                    }
                    // 获取 haystack 中参加匹配的最末位字符的下一位字符
                    char val = charH[i + n];
                    // 找 needle 中某位匹配此字符的位置
                    int index = search (charN, val);
                    if (index == -1) {
                        // 没有则直接移动 n + 1
                        i += n + 1;
                    } else {
                        // 有则将两个字符串对齐, 然后再开始匹配
                        i += n - index;
                    }
                    j = 0;
                }
            }
        }

        return -1;
    }

    /**
     * 等效于 lastIndexOf
     *
     * @param str    查询字符数组
     * @param target 目标字符
     * @return
     */
    private int search(char[] str, char target) {

        int index = -1;

        for (int i = str.length - 1; i >= 0; i--) {
            if (str[i] == target) {
                index = i;
                break;
            }
        }
        return index;
    }

}
