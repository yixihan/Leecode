package com.yixihan.month02.day1130;


/**
 * 给你一个整数 n ，请你在无限的整数序列 [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...] 中找出并返回第 n 位数字。
 *
 * 输入：n = 3
 * 输出：3
 *
 * 输入：n = 11
 * 输出：0
 * 解释：第 11 位数字在序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... 里是 0 ，它是 10 的一部分。
 *
 * @author : yixihan
 * @create : 2021-11-30-13:37
 */
public class FindNthDigit {

    /**
     * 相当于取字符串 12345678910111213... 的第 n 个位置的值
     *
     * 步骤 :
     *      1. 小于10，直接返回。(step 1)
     *      2. 否则，计算前缀部分，全部被占用部分总共有多少位即length。(step 2)
     *      3. 计算尾部，其一、计算第一个数字即pow(10, i-1)。其二、推理出最后一个出现的多位数字即num，并计算出位于第几位即index。(step 3)
     *
     * 1234567891011121314151617181920
     * 1 - [1,9]             9
     * 2 - [10,99]          90
     * 3 - [100,999]       900
     * 4 - [1000,9999]    9000
     * .........2^31-1 = 2147483647
     */
    public int findNthDigit(int n) {

        if (n < 10) {
            return n;
        }

        long length = 0L;
        long cnt = 9L;
        long i = 1L;

        for (; length + cnt * i < n; ++i) {
            length += cnt * i;
            cnt *= 10;
        }

        long num = (long) (Math.pow (10, i - 1) + (n - length - 1) / i);
        long index = (n - length - 1) % i;
        return String.valueOf (num).charAt ((int) index) - '0';
    }
}
