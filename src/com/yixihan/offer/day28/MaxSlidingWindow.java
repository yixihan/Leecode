package com.yixihan.offer.day28;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 * <p>
 * 示例:
 * <p>
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 * <p>
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 *
 * @author : yixihan
 * @create : 2022-03-19-11:23
 */
public class MaxSlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {
        // 方法一 : 自己想的, 利用 PriorityQueue 队列单调性解决
        //        if (nums == null || nums.length == 0) {
        //            return new int[]{};
        //        }
        //
        //        Queue<Integer> queue = new PriorityQueue<> ((o1, o2) -> o2 - o1);
        //
        //        int left = 0;
        //        int right = k - 1;
        //        int n = nums.length;
        //        int[] ans = new int[nums.length - k + 1];
        //        int index = 0;
        //
        //        while (left <= right) {
        //            queue.add (nums[left++]);
        //        }
        //        ans[index++] = queue.peek ();
        //
        //        for (int i = right + 1; i < n; i++) {
        //            queue.add (nums[i]);
        //            queue.remove (nums[i - k]);
        //            ans[index++] = queue.peek ();
        //        }
        //
        //        return ans;

        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int[] res = new int[nums.length - k + 1];
        Deque<Integer> queue = new ArrayDeque<> ();

        for (int i = 0, j = 0; i < nums.length; i++) {
            if (!queue.isEmpty () && i - queue.peek () >= k) {
                queue.poll ();
            }
            while (!queue.isEmpty () && nums[i] > nums[queue.peekLast ()]) {
                queue.pollLast ();
            }
            queue.offer (i);
            if (i >= k - 1) {
                res[j++] = nums[queue.peek ()];
            }
        }

        return res;
    }
}
