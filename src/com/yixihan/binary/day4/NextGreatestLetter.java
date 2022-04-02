package com.yixihan.binary.day4;

/**
 * 给你一个排序后的字符列表 letters ，列表中只包含小写英文字母。另给出一个目标字母 target，
 * 请你寻找在这一有序列表里比目标字母大的最小字母。
 * <p>
 * 在比较时，字母是依序循环出现的。举个例子：
 * <p>
 * 如果目标字母 target = 'z' 并且字符列表为 letters = ['a', 'b']，则答案返回 'a'
 * <p>
 * 输入: letters = ["c", "f", "j"]，target = "a"
 * 输出: "c"
 * <p>
 * 输入: letters = ["c","f","j"], target = "c"
 * 输出: "f"
 * <p>
 * 输入: letters = ["c","f","j"], target = "d"
 * 输出: "f"
 *
 * @author : yixihan
 * @create : 2022-03-31-0:30
 */
public class NextGreatestLetter {
    public char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;
        int left = 0;
        int right = n - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (letters[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return letters[left % n];
    }
}
