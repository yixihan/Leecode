package com.yixihan.random.day0906;

/**
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
 * <p>
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。：
 * <p>
 * 输入：s = ["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 * 示例 2：
 * <p>
 * 输入：s = ["H","a","n","n","a","h"]
 * 输出：["h","a","n","n","a","H"]
 *
 * @author : yixihan
 * @create : 2022-09-06-13:15
 */
public class ReverseString {

    public void reverseString(char[] s) {
        reverse (s, 0, s.length - 1);
    }

    private void reverse(char[] c, int l, int r) {
        if (l < r) {
            swap (c, l, r);
            l++;
            r--;
            reverse (c, l, r);
        }
    }

    private void swap(char[] c, int i, int j) {
        char tmp = c[i];
        c[i] = c[j];
        c[j] = tmp;
    }
}
