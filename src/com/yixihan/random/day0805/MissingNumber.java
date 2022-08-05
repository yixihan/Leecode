package com.yixihan.random.day0805;

/**
 * 数组nums包含从0到n的所有整数，但其中缺了一个。请编写代码找出那个缺失的整数。你有办法在O(n)时间内完成吗？
 * <p>
 * 注意：本题相对书上原题稍作改动
 * <p>
 * 输入：[3,0,1]
 * 输出：2
 * <p>
 * 输入：[9,6,4,2,3,5,7,0,1]
 * 输出：8
 *
 * @author : yixihan
 * @create : 2022-08-05-15:14
 */
public class MissingNumber {

    public int missingNumber(int[] nums) {
        int sum = 0;
        int cnt = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += i;
            cnt += nums[i];
        }

        return sum + nums.length - cnt;
    }
}
