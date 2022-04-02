package com.yixihan.month01.day1106;

import org.junit.jupiter.api.Test;

/**
 * @author : yixihan
 * @create : 2021-11-06-22:59
 */
public class MissingNumber {

    /**
     * 亦或操作
     */
    public int missingNumber(int[] nums) {

        int res = nums.length;
        for (int i = 0; i < nums.length; ++i){
            res ^= nums[i];
            res ^= i;
        }
        return res;
    }

    /**
     * 求和法, 先加再减, 最后再减去 length 求绝对值即可
     */
    public int missingNumber1(int[] nums) {

        int sum = 0;
        int i = 0;

        for (; i < nums.length; i++) {
            sum += nums[i] - i;
        }
        sum -= i;

        return Math.abs(sum);
    }

    @Test
    public void test () {

        System.out.println(missingNumber(new int[]{0, 1, 3, 4, 5, 6, 7, 8, 9}));
        System.out.println(missingNumber1(new int[]{0, 1, 3, 4, 5, 6, 7, 8, 9}));
    }
}
