package com.yixihan.month05.day0220;

/**
 * 有两种特殊字符：
 *
 * 第一种字符可以用一个比特 0 来表示
 * 第二种字符可以用两个比特(10 或 11)来表示、
 * 给定一个以 0 结尾的二进制数组 bits ，如果最后一个字符必须是一位字符，则返回 true 。
 *
 * 输入: bits = [1, 0, 0]
 * 输出: true
 * 解释: 唯一的编码方式是一个两比特字符和一个一比特字符。
 * 所以最后一个字符是一比特字符。
 *
 * 输入: bits = [1, 1, 1, 0]
 * 输出: false
 * 解释: 唯一的编码方式是两比特字符和两比特字符。
 * 所以最后一个字符不是一比特字符。
 *
 * @author : yixihan
 * @create : 2022-02-20-9:42
 */
public class Solution {
    public boolean isOneBitCharacter(int[] bits) {

        if (bits[bits.length - 1] != 0) {
            return false;
        }

        int count = 0;
        for (int i = bits.length - 2; i >= 0; i--) {
            if (bits[i] == 1) {
                count++;
            } else {
                break;
            }
        }

        return count % 2 == 0;
    }
}
