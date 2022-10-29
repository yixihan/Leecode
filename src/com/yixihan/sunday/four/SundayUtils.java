package com.yixihan.sunday.four;

/**
 * @author yixihan
 * @date 2022-10-28-17:42
 */
public class SundayUtils {

    public static int strStr(String haystack, String needle) {

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
                // 判断 i + n 是否过界
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
     * @param str 查询字符数组
     * @param target 目标字符
     * @return
     */
    private static int search (char[] str, char target) {

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
