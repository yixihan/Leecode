package com.yixihan.month06.day0405;

import java.util.Arrays;

/**
 * @author : yixihan
 * @create : 2022-04-05-14:09
 */
public class Solution {

    int[] arr = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31};

    public int countPrimeSetBits(int left, int right) {

        int ans = 0;

        for (int i = left; i <= right; i++) {
            int count = Integer.bitCount (i);
            if (Arrays.binarySearch (arr, count) >= 0) {
                ans++;
            }
        }

        return ans;
    }
}
