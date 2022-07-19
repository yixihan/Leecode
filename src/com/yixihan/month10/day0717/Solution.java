package com.yixihan.month10.day0717;

import java.util.LinkedHashSet;

/**
 * 索引从0开始长度为N的数组A，包含0到N - 1的所有整数。
 * 找到最大的集合S并返回其大小，其中 S[i] = {A[i], A[A[i]], A[A[A[i]]], ... }且遵守以下的规则。
 * <p>
 * 假设选择索引为i的元素A[i]为S的第一个元素，S的下一个元素应该是A[A[i]]，之后是A[A[A[i]]]... 以此类推，不断添加直到S出现重复的元素。
 * <p>
 * 输入: A = [5,4,0,3,1,6,2]
 * 输出: 4
 * 解释:
 * A[0] = 5, A[1] = 4, A[2] = 0, A[3] = 3, A[4] = 1, A[5] = 6, A[6] = 2.
 * 其中一种最长的 S[K]:
 * S[0] = {A[0], A[5], A[6], A[2]} = {5, 6, 2, 0}
 *
 * @author : yixihan
 * @create : 2022-07-17-8:38
 */
public class Solution {

    public int arrayNesting(int[] nums) {
        int ans = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] != n) {
                int cnt = 0;
                while (nums[i] != n) {
                    cnt++;
                    int j = nums[i];
                    nums[i] = n;
                    i = j;
                }
                ans = Math.max (cnt, ans);
            }
        }

        return ans;
    }
}