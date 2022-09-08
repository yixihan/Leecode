package com.yixihan.random.day0908;

/**
 * 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
 * <p>
 * 请注意，你可以假定字符串里不包括任何不可打印的字符。
 * <p>
 * 输入: "Hello, my name is John"
 * 输出: 5
 * 解释: 这里的单词是指连续的不是空格的字符，所以 "Hello," 算作 1 个单词。
 *
 * @author : yixihan
 * @create : 2022-09-08-15:34
 */
public class CountSegments {

    public int countSegments(String s) {
        char[] arr = s.toCharArray ();
        int n = arr.length;
        int ans = 0;
        for (int i = 0; i < n; ) {
            if (arr[i] == ' ') {
                i++;
                continue;
            }
            while (i < n && arr[i] != ' ') {
                i++;
            }
            ans++;
        }
        return ans;

    }
}
