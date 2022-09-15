package com.yixihan.random.day0915;

/**
 * 数组中占比超过一半的元素称之为主要元素。给你一个 整数 数组，找出其中的主要元素。
 * 若没有，返回 -1 。请设计时间复杂度为 O(N) 、空间复杂度为 O(1) 的解决方案。
 * <p>
 * 输入：[1,2,5,9,5,9,5,5,5]
 * 输出：5
 * <p>
 * 输入：[3,2]
 * 输出：-1
 * <p>
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 *
 * @author : yixihan
 * @create : 2022-09-15-10:35
 */
public class MajorityElement {

    public int majorityElement(int[] nums) {
        int cnt = 1;
        int val = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (val == nums[i]) {
                cnt++;
            } else {
                if (--cnt == 0) {
                    cnt = 1;
                    val = nums[i];
                }
            }
        }
        cnt = 0;
        for (int num : nums) {
            if (num == val) {
                cnt++;
            }
        }

        return cnt >= nums.length / 2 ? val : -1;
    }
}
