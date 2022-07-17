package com.yixihan.random.day0717;

/**
 * 给你一个整数 num，请你找出同时满足下面全部要求的两个整数：
 * <p>
 * 两数乘积等于  num + 1 或 num + 2
 * 以绝对差进行度量，两数大小最接近
 * 你可以按任意顺序返回这两个整数。
 * <p>
 * 输入：num = 8
 * 输出：[3,3]
 * 解释：对于 num + 1 = 9，最接近的两个因数是 3 & 3；对于 num + 2 = 10, 最接近的两个因数是 2 & 5，因此返回 3 & 3 。
 * <p>
 * 输入：num = 123
 * 输出：[5,25]
 * <p>
 * 输入：num = 999
 * 输出：[40,25]
 *
 * @author : yixihan
 * @create : 2022-07-17-9:09
 */
public class ClosestDivisors {
    public int[] closestDivisors(int num) {
        int divisor = num == 1 ? num + 1 : num + 2;
        int i = (int) Math.sqrt (divisor);

        while (divisor % i > 1) {
            i--;
        }

        return new int[]{i, divisor / i};
    }
}
