package com.yixihan.month03.day0114;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 给定两个以升序排列的整数数组 nums1 和 nums2 , 以及一个整数 k 。
 *
 * 定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2 。
 *
 * 请找到和最小的 k 个数对 (u1,v1),  (u2,v2)  ...  (uk,vk) 。
 *
 * 输入: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
 * 输出: [1,2],[1,4],[1,6]
 * 解释: 返回序列中的前 3 对数：
 *      [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 *
 * 输入: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
 * 输出: [1,1],[1,1]
 * 解释: 返回序列中的前 2 对数：
 *      [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
 *
 * 输入: nums1 = [1,2], nums2 = [3], k = 3 
 * 输出: [1,3],[2,3]
 * 解释: 也可能序列中所有的数对都被返回:[1,3],[2,3]
 *
 * @author : yixihan
 * @create : 2022-01-14-6:43
 */
public class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        List<List<Integer>> ans = new ArrayList<>();
        PriorityQueue<int[]> queue = new PriorityQueue<> (
                (x, y) -> nums1[x[0]] + nums2[x[1]] - nums1[y[0]] - nums2[y[1]]
        );

        for (int i = 0; i < Math.min (k, nums1.length); i++) {
            queue.offer (new int[]{i, 0});
        }

        while (queue.size () > 0 && k-- > 0) {
            int[] cur = queue.poll ();
            ans.add (new ArrayList<> (Arrays.asList (nums1[cur[0]], nums2[cur[1]])));

            if (cur[1] < nums2.length - 1) {
                queue.offer (new int[]{cur[0], cur[1] + 1});
            }
        }

        return ans;
    }
}
