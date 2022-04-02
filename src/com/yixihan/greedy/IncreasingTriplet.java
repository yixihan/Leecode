package com.yixihan.greedy;

/**
 * @author : yixihan
 * @create : 2022-03-18-14:54
 */
public class IncreasingTriplet {
    public boolean increasingTriplet(int[] nums) {

        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num <= minValue) {
                minValue = num;
            } else if (num <= maxValue) {
                maxValue = num;
            } else {
                return true;
            }
        }

        return false;
    }
}
