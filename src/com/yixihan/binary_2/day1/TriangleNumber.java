package com.yixihan.binary_2.day1;

import java.util.Arrays;

/**
 * 给定一个包含非负整数的数组 nums ，返回其中可以组成三角形三条边的三元组个数。
 * <p>
 * 输入: nums = [2,2,3,4]
 * 输出: 3
 * 解释:有效的组合是:
 * 2,3,4 (使用第一个 2)
 * 2,3,4 (使用第二个 2)
 * 2,2,3
 * <p>
 * 输入: nums = [4,2,3,4]
 * 输出: 4
 *
 * @author : yixihan
 * @create : 2022-04-11-15:52
 */
public class TriangleNumber {
    public int triangleNumber(int[] nums) {

        // 暴力
//        Arrays.sort (nums);
//        int n = nums.length;
//        int index1 = 0;
//        int index2 = index1 + 1;
//        int ans = 0;
//
//        while (index1 < n - 2) {
//            while (index2 < n - 1) {
//                int val = nums[index1] + nums[index2];
//
//                int index = index2 + 1;
//                while (index < n && val > nums[index]) {
//                    ans++;
//                    index++;
//                }
//                index2++;
//            }
//            index1++;
//            index2 = index1 + 1;
//        }
//
//        return ans;

        // 2, 3层循环合一, 从后往前遍历
        Arrays.sort (nums);
        int n = nums.length;
        int ans = 0;

        for (int i = n - 1; i >= 2; i--) {
            int k = 0;
            int j = i - 1;

            while (k < j) {
                if (nums[k] + nums[j] > nums[i]) {
                    ans += j - k;
                    j--;
                } else {
                    k++;
                }
            }
        }

        return ans;

    }
}
