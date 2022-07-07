package com.yixihan.random.day0707;

/**
 * 给你一个 数字 字符串数组 nums 和一个 数字 字符串 target ，
 * 请你返回 nums[i] + nums[j] （两个字符串连接）结果等于 target 的下标 (i, j) （需满足 i != j）的数目。
 * <p>
 * 输入：nums = ["777","7","77","77"], target = "7777"
 * 输出：4
 * 解释：符合要求的下标对包括：
 * - (0, 1)："777" + "7"
 * - (1, 0)："7" + "777"
 * - (2, 3)："77" + "77"
 * - (3, 2)："77" + "77"
 * <p>
 * 输入：nums = ["123","4","12","34"], target = "1234"
 * 输出：2
 * 解释：符合要求的下标对包括
 * - (0, 1)："123" + "4"
 * - (2, 3)："12" + "34"
 * <p>
 * 输入：nums = ["1","1","1"], target = "11"
 * 输出：6
 * 解释：符合要求的下标对包括
 * - (0, 1)："1" + "1"
 * - (1, 0)："1" + "1"
 * - (0, 2)："1" + "1"
 * - (2, 0)："1" + "1"
 * - (1, 2)："1" + "1"
 * - (2, 1)："1" + "1"
 *
 * @author : yixihan
 * @create : 2022-07-07-8:29
 */
public class NumOfPairs {

    public int numOfPairs(String[] nums, String target) {

        int ans = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                if (target.equals (nums[i] + nums[j])) {
                    ans++;
                }
            }
        }

        return ans;
    }
}
