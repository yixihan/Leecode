package com.yixihan.random.day0715;

/**
 * 两个整数之间的 汉明距离 指的是这两个数字对应二进制位不同的位置的数目。
 * <p>
 * 给你两个整数 x 和 y，计算并返回它们之间的汉明距离。
 * <p>
 * 输入：x = 1, y = 4
 * 输出：2
 * 解释：
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 * 上面的箭头指出了对应二进制位不同的位置。
 * <p>
 * 输入：x = 3, y = 1
 * 输出：1
 *
 * @author : yixihan
 * @create : 2022-07-15-9:50
 */
public class HammingDistance {
    public int hammingDistance(int x, int y) {

        return Integer.bitCount (x ^ y);
    }
}
