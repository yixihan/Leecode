package com.yixihan.random.day0715;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 给你一个整数数组 nums 和一个整数 k 。你需要找到 nums 中长度为 k 的 子序列 ，且这个子序列的和最大 。
 * <p>
 * 请你返回 任意 一个长度为 k 的整数子序列。
 * <p>
 * 子序列 定义为从一个数组里删除一些元素后，不改变剩下元素的顺序得到的数组。
 * <p>
 * 输入：nums = [2,1,3,3], k = 2
 * 输出：[3,3]
 * 解释：
 * 子序列有最大和：3 + 3 = 6 。
 * <p>
 * 输入：nums = [-1,-2,3,4], k = 3
 * 输出：[-1,3,4]
 * 解释：
 * 子序列有最大和：-1 + 3 + 4 = 6 。
 * <p>
 * 输入：nums = [3,4,3,3], k = 2
 * 输出：[3,4]
 * 解释：
 * 子序列有最大和：3 + 4 = 7 。
 * 另一个可行的子序列为 [4, 3] 。
 *
 * @author : yixihan
 * @create : 2022-07-15-9:38
 */
public class MaxSubsequence {

    public int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<int[]> queue1 = new PriorityQueue<> ((o1, o2) -> o2[0] - o1[0]);
        PriorityQueue<int[]> queue2 = new PriorityQueue<> (Comparator.comparingInt (o -> o[1]));

        int[] ans = new int[k];

        for (int i = 0; i < nums.length; i++) {
            queue1.add (new int[]{nums[i], i});
        }

        int index = 0;
        while (index++ < k && !queue1.isEmpty ()) {
            queue2.add (queue1.remove ());
        }
        index = 0;
        while (index < k) {
            ans[index++] = queue2.remove ()[0];
        }

        return ans;
    }
}
