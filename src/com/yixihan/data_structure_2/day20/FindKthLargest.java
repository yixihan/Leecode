package com.yixihan.data_structure_2.day20;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * <p>
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * <p>
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 *
 * @author : yixihan
 * @create : 2022-04-12-10:11
 */
public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        // 调用库函数
        //        Arrays.sort (nums);
        //
        //        return nums[nums.length - k];

        // 快排
        //        quickSort (nums, 0, nums.length - 1);
        //
        //        return nums[nums.length - k];

        // 优先队列
        Queue<Integer> queue = new PriorityQueue<> ((o1, o2) -> o2 - o1);

        for (int num : nums) {
            queue.add (num);
        }
        System.out.println (queue);

        for (int i = 0; i < k; i++) {
            queue.poll ();
        }

        return queue.poll ();
    }

    private void quickSort(int[] nums, int start, int end) {
        int l = start;
        int r = end;
        int midVal = nums[(start + end) / 2];

        while (l < r) {
            while (midVal > nums[l]) {
                l++;
            }

            while (midVal < nums[r]) {
                r--;
            }

            if (l >= r) {
                break;
            }

            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;

            if (nums[l] == midVal) {
                r--;
            }
            if (nums[r] == midVal) {
                l++;
            }
        }

        if (l == r) {
            r--;
            l++;
        }

        if (l < end) {
            quickSort (nums, l, end);
        }
        if (start < r) {
            quickSort (nums, start, r);
        }
    }
}
