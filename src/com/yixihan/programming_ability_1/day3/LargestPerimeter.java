package com.yixihan.programming_ability_1.day3;

import java.util.Arrays;

/**
 * 给定由一些正数（代表长度）组成的数组 nums ，返回 由其中三个长度组成的、面积不为零的三角形的最大周长 。
 * 如果不能形成任何面积不为零的三角形，返回 0。
 *
 *
 * 输入：nums = [2,1,2]
 * 输出：5
 *
 * 输入：nums = [1,2,1]
 * 输出：0
 *
 * @author : yixihan
 * @create : 2022-03-13-10:44
 */
public class LargestPerimeter {
    public int largestPerimeter(int[] nums) {

        Arrays.sort (nums);
        int ans  = 0;

        for (int i = nums.length - 1, j = nums.length - 2, k = nums.length - 3; i >= 2; ) {
            int maxEdge = nums[i];
            int edge1 = nums[j];
            int edge2 = nums[k];

            if (maxEdge >= edge1 + edge2) {
                i--;
                j--;
                k--;
            } else {
                ans = maxEdge + edge1 + edge2;
                break;
            }
        }
        return ans;
    }
}
