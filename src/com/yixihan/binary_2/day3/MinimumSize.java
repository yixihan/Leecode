package com.yixihan.binary_2.day3;

/**
 * @author : yixihan
 * @create : 2022-04-13-13:47
 */
public class MinimumSize {
    public int minimumSize(int[] nums, int maxOperations) {
        int l = 1;
        int r = Integer.MIN_VALUE;
        for (int num : nums) {
            r = Math.max (r, num);
        }

        while (l < r) {
            int m = (l + r) >> 1;
            int t = 0;

            for (int num : nums) {
                if (num <= m) {
                    continue;
                }
                t += num / m;
                if (num % m == 0) {
                    t--;
                }
            }

            if (t > maxOperations) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        return l;
    }
}
