package com.yixihan.competition.week286;

/**
 * @author : yixihan
 * @create : 2022-03-27-10:42
 */
public class MinDeletion {
    public int minDeletion(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int ans = 0;
        int index = 0;
        int length = nums.length;
        for (int i = 0; i < nums.length - 1; i++) {
            if (index % 2 == 0 && nums[i] == nums[i + 1]) {
                ans++;
                length--;
                continue;
            }
            index++;
        }
        if (length % 2 != 0) {
            ans++;
        }

        return ans;

    }
}
