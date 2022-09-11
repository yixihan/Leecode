package com.yixihan.random.day0911;

/**
 * 给定一个二进制数组 nums ， 计算其中最大连续 1 的个数。
 * <p>
 * 输入：nums = [1,1,0,1,1,1]
 * 输出：3
 * 解释：开头的两位和最后的三位都是连续 1 ，所以最大连续 1 的个数是 3.
 * <p>
 * 输入：nums = [1,0,1,1,0,1]
 * 输出：2
 *
 * @author : yixihan
 * @create : 2022-09-11-10:23
 */
public class FindMaxConsecutiveOnes {

    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCnt = 0;
        int cnt = 0;

        for (int num : nums) {
            if (num == 1) {
                cnt++;
            } else {
                maxCnt = Math.max (maxCnt, cnt);
                cnt = 0;
            }
        }

        return Math.max (maxCnt, cnt);
    }
}
